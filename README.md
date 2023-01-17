# SuiteCRM Demo Project

This project is a demo project for the automation of a CRM system using Selenium / QTAF.

## Voraussetzungen

The following tools must be installed on your PC:
- Java 17+
- Maven
- Docker
- Docker Compose

## Set up project

Clone this Git repository to your PC using `git clone https://github.com/Qytera-Gmbh/QTAF-SuiteCRM-Demo` and then execute the command `docker-compose up -d` in the directory to which you have cloned this project.
Furthermore, a container for the SuiteCRM project is created as well as another container for the database required by SuiteCRM.

| Container | Hostname | Port |
|-----------|----------|------|
| SuiteCRM  | suitecrm | 8080 |
| MariaDB   | mariadb  | -    |

Now open a new tab in the browser and enter the following URL: `http://localhost:80`. You should now see the SuiteCRM interface.
It may take a few minutes for the project to be set up. The username is `user` and the password is `bitnami`.

## Use selenium docker containers

If you do not want to set up Selenium yourself, you can do so using Docker as follows:
In the root directory of the project you will find the file `docker-compose.selenium.yml`, in which the containers for the Selenium drivers are defined. A total of two drivers are provided for the Chrome and Firefox browsers. Start the containers by navigating to the root directory of the project and then entering the command `docker-compose up -d`. When starting the containers for the first time, the required images for the Selenium containers must first be downloaded, which may take some time.

After the containers have been started, the following drivers are available under the following ports:

| Selenium-Treiber | Hostname         | Port |
|------------------|------------------|------|
| Chrome           | selenium-chrome  | 4444 |
| Firefox          | selenium-firefox | 4445 |



Now you can start the test cases. To do this, execute the following command to start the test cases in the Selenium Chrome container:
```bash
$ mvn exec:java -Dexec.mainClass="de.qytera.suite_crm.TestRunner" \
    -Ddriver.name="chrome-remote" \
    -DpageUrl="http://suitecrm:8080" \
    -Ddriver.remoteUrl="http://localhost:4444/wd/hub"
```

Note here that we use the host name `suitecrm` for the URL instead of `localhost`. This is because the test cases are executed in the Selenium container and `localhost` refers to the container itself. Thus, we specify `suitecrm` as the hostname, which corresponds to the container name defined in the file `docker-compsose.selenium.yml`.
For the hostname of the driver we can still use `localhost`, since the Maven process does not run inside a Docker container.

If you want to test with Firefox instead of Chrome, change the parameters `driver.name` and `driver.remoteUrl` as follows:
```bash
$ mvn exec:java -Dexec.mainClass="de.qytera.suite_crm.TestRunner" \
    -Ddriver.name="firefox-remote" \
    -DpageUrl="http://suitecrm:8080" \
    -Ddriver.remoteUrl="http://localhost:4445/wd/hub"
```

You can also find the corresponding commands in the folder `./scripts/run` in this project.

### Shut down containers

You can shut down the containers again with the following command:

```bash
$ docker-compose down
```

## Kubernetes

Open a console, navigate to the root directory of this project and then execute the following command:

```bash
$ kubectl apply -f k8s
```

This command creates the containers defined in the YAML files in the folder `k8s`.

### Use under Windows

If you are using the Kubernetes version on Windows that you installed using Docker for Desktop, it is not sufficient to just start the containers. In this case, you must also manually perform port sharing. To forward traffic from a port on your local machine to a port on a container, enter the following command:

```
# Allgemein
$ kubectl port-forward deployment/<deployment-name> <local-port>:<container-port>

# Am Beispiel des Selenium-Containers
$ kubectl port-forward deployment/selenium-chrome 4444:4444
```

The output should be something like the following:

```bash
Forwarding from 127.0.0.1:4444 -> 4444
Forwarding from [::1]:4444 -> 4444
```

Note that you must open a new console for each port forwarding. You can stop port-forwarding by using CTRL+C.

You will find the corresponding commands in the directory `scripts/k8s/port-forwarding`.
More information about port-forwarding can be found here: https://kubernetes.io/docs/tasks/access-application-cluster/port-forward-access-application-cluster/.

Once the containers are running, you can start the tests from your local machine with the following command:

```
$ mvn exec:java -Dexec.mainClass="de.qytera.suite_crm.TestRunner" \
    -Ddriver.name="chrome-remote" \
    -DpageUrl="http://suitecrm:8080" \
    -Ddriver.remoteUrl="http://localhost:4444/wd/hub"
```

You can see that this command is identical to the command used with `docker-compose`.