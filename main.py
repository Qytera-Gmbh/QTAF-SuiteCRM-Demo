import os, subprocess, time, sys, re
import reactivex as rx


class Process:
    def __init__(self, cmd: list, print_stdout=False):
        self.cmd = cmd
        self.print_stdout = print_stdout
        self.p = None
        self.exit_code = None
        self.on_stdout_readline = rx.subject.Subject()
        self.on_process_start = rx.subject.Subject()
        self.on_process_finished = rx.subject.Subject()
        self.last_line = ""
        self.out = []
        self.err = []
        self.finished = False

    def stdout_logger(self, p):
        self.out.append(p.get_last_line_from_stdout())
        print(p.get_last_line_from_stdout())

    def register_stdout_readline_handler(self, f):
        self.on_stdout_readline.subscribe(f)

    def write(self, value: str):
        self.get_stdin().write(value)
        self.get_stdin().flush()

    def get_last_line_from_stdout(self) -> str:
        return self.last_line

    def get_stdin(self):
        return self.p.stdin

    def get_stdout(self):
        return self.p.stdout

    def get_stderr(self):
        return self.p.stderr

    def get_output() -> list:
        return self.out

    def get_error() -> list:
        return self.err

    def is_finished() -> bool:
        return self.finished

    def run(self):
        # Check if process was already executed
        if self.finished:
            return self.out, self.err, self.exit_code

        # Register event handlers
        if (self.print_stdout):
            self.register_stdout_readline_handler(self.stdout_logger)

        # Start process
        self.on_process_start.on_next(None)
        self.on_process_start.on_completed()

        self.p = subprocess.Popen(
            self.cmd,
            stdin=subprocess.PIPE,
            stdout=subprocess.PIPE,
            stderr=subprocess.PIPE
        )

        # Iterate over stdout
        for line in iter(self.p.stdout.readline, b''):
            # Decode byte array from stdout
            self.last_line = line.rstrip().decode("utf-8")
            # Dispatch event
            self.on_stdout_readline.on_next(self)

        # Stdout handler
        if (self.p.stderr):
            for line in iter(self.p.stderr.readline, b''):
                s = line.rstrip().decode("utf-8")
                self.err.append(s)
                print(s)

        # Get exit code
        self.exit_code = self.p.wait()
        self.finished = True

        self.on_stdout_readline.on_completed()
        self.on_process_finished.on_next(None)
        self.on_process_finished.on_completed()

        return self.out, self.err, self.exit_code


terraform_dir = "terraform"

def stdin_writer(p):
    if (len(re.findall("var.instance", p.get_last_line_from_stdout()))):
        p.write('t2.xlarge\n'.encode("utf-8"))

p = Process(["terraform", "-chdir={}".format(terraform_dir), "plan"], print_stdout=True)
p.register_stdout_readline_handler(stdin_writer)
stdout, stderr, exit_code = p.run()
print(len(stdout), len(stderr), exit_code)