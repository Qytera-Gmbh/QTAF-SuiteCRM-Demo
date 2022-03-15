import os, subprocess, time, sys, re
import reactivex as rx

terraform_dir = "terraform"

cmd_terraform_apply = ["terraform", "-chdir={}".format(terraform_dir), "apply"]
cmd_terraform_destroy = ["terraform", "-chdir={}".format(terraform_dir), "destroy"]
cmd_terraform_plan = ["terraform", "-chdir={}".format(terraform_dir), "plan"]
cmd_test = ["python", "--version"]
cmd_docker_ps = ["docker", "ps"]

p = subprocess.Popen(cmd_terraform_plan,
                     stdin=subprocess.PIPE,
                     stdout=subprocess.PIPE,
                     stderr=subprocess.PIPE)

out = []
err = []

subject_out = rx.subject.Subject()

def stdout_logger(p):
    out.append(p["s"])
    print(p["s"])

def stdin_writer(p):
    if (len(re.findall("var.instance", p["s"]))):
        print("INPUT: var.instance")
        p["stdin"].write('t2.xlarge\n'.encode("utf-8"))
        p["stdin"].flush()
    if ("Enter a value" in s):
        print("INPUT: Enter a value")
        #p["p"].terminate()


# Print subscriber
subject_out.subscribe(stdout_logger)
subject_out.subscribe(stdin_writer)

for line in iter(p.stdout.readline, b''):
    s = line.rstrip().decode("utf-8")
    subject_out.on_next({"p": p, "s": s, "stdin": p.stdin, "stdout": p.stdout, "stderr": p.stderr})

if (p.stderr):
    for line in iter(p.stderr.readline, b''):
        s = line.rstrip().decode("utf-8")
        err.append(s)
        print(s)

exit_code = p.wait()
print("DONE", len(out), len(err), exit_code)