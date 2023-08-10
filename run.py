import os, threading, click, json


from qytera_process import Process

# ! INFO !
# You have to run "mvn clean install" before executing the python script. The target directory has to be available


class ConfigurationLoader:
    def load_configuration(self) -> dict:
        data = {}
        with open('qtaf.json', 'r') as f:
            data = json.load(f)
        return data

configuration_loader = ConfigurationLoader()

data = configuration_loader.load_configuration()
envs = data["envs"]

def run_docker_up():
    p_docker_up = Process(["docker-compose", "up", "-d"], print_stdout=True)
    return p_docker_up.run()

def run_docker_down():
    p_docker_down = Process(["docker-compose", "down"], print_stdout=True)
    return p_docker_down.run()

def _run_test(env, name=""):
    my_env = os.environ.copy()
    my_env.update(env)

    p = Process([
        "mvn",
        "clean",
        "test",
        ],
        print_stdout=True,
        shell=True,
        env=my_env,
        name=name,
    )

    return p.run()

@click.group()
@click.option('--debug/--no-debug', default=False)
def cli(debug):
    click.echo(f"Debug mode is {'on' if debug else 'off'}")


@cli.command()
@click.argument('name')
def run_test(name):
    envs_filtered = list(filter(lambda _env: _env["name"] == name, envs))

    if (len(envs_filtered)):
        return _run_test(envs_filtered[0]["vars"], name=name)

    click.echo("No environment found with the given name {}".format(name))


@cli.command()
@click.option('--n-parallel', default=2)
@click.option('--groups', default="")
def run_tests(n_parallel: int, groups: str):
    groups=set(groups.split(","))
    envs = list(filter(lambda env: set(env["groups"]).intersection(groups), data["envs"]))

    qtaf_threads = []
    try:
        rounds = len(envs) // n_parallel
        if len(envs) % n_parallel > 0:
            rounds += 1

        for round in range(rounds):
            index_start = round * n_parallel
            envs_round = envs[index_start:index_start+n_parallel]
            for i, env in enumerate(envs_round):
                t = threading.Thread(
                target=_run_test,
                kwargs={
                    "env": envs[index_start+i]["vars"],
                    "name": envs[index_start+i]["name"]
                   }
                )
                qtaf_threads.append(t)
                t.start()

            for i, _ in enumerate(envs_round):
                qtaf_threads[i].join()
    except Exception as e:
        print("Error: Unable to start thread", e)


@cli.command()
@click.argument("name")
def task(name: str):
    """
    Run task from qtaf.json file
    """
    cmds = data["tasks"][name]
    for cmd in cmds:
        arr = cmd.split(" ")
        p = Process(arr, print_stdout=True, name=name)
        p.run()


@cli.command()
def env_up():
    # Start docker containers
    res_docker_up = run_docker_up()


@cli.command()
def env_down():
    # Start docker containers
    res_docker_down = run_docker_down()

if __name__ == '__main__':
    cli(obj={})