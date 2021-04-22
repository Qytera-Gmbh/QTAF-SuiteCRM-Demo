# SuiteCRM Demo Projekt

Dieses Projekt ist ein Demoprojekt für die Automatisierung eines CRM-Systems mittels Selenium / QTAF.

## Voraussetzungen

Auf Ihrem PC muss installiert sein:
- Docker
- Docker Compose
- Kubernetes
- Maven

## Projekt aufsetzen

Klonen Sie sich dieses Git-Repository mittels `git clone https://bitbucket.org/qytera/qtaf-suitecrm-tests` auf Ihren PC und führen Sie anschließend in dem Verzeichnis, in das Sie dieses Projekt geklont haben den Befehl `docker-compose up -d` aus. Es kann einige Minuten dauern, bis das Projekt eingerichtet worden ist. Anschließend können Sie in Ihrem Browser die Adresse `http://localhost:8080` öffnen. Der Standardusername lautet `user` und das Standardpasswort `bitnami`.

## Selenium Docker-Container mittels docker-compose starten

Im Stammverzeichnis des Projekts finden Sie die Datei `docker-compose.yml`, in welcher die Container für die Selenium-Treiber definiert sind. Insgesamt werden vier Treiber für die Browser Chrome, Firefox, Opera und Edge bereitgestellt. Starten Sie die Container, indem Sie in das Stammverzeichnis des Projektes navigieren und anschließend den Befehl `docker-compose up -d` eingeben. Beim erstmaligen Starten der Container müssen die benötigten Images für die Selenium-Container zunächst heruntergeladen werden, was etwas Zeit in Anspruch nehmen kann.

Nachdem die Container gestartet worden sind stehen folgende Treiber unter folgenden Ports bereit:

| Selenium-Treiber | Hostname         | Port |
|------------------|------------------|------|
| Chrome           | selenium-chrome  | 4444 |
| Firefox          | selenium-firefox | 4445 |
| Opera            | selenium-opera   | 4446 |
| Edge             | selenium-edge    | 4447 |

Weiterhin wird ein Container für das SuiteCRM-Projekt erstellt sowie ein weiterer Container für die von SuiteCRM benötigte Datenbank.

| Container | Hostname | Port |
|-----------|----------|------|
| SuiteCRM  | suitecrm | 8080 |
| MariaDB   | mariadb  | -    |

Öffnen Sie nun im Browser einen neuen Tab und geben Sie folgende URL ein: `http://localhost:8080`. Sie sollten jetzt die Oberfläche von SuiteCRM sehen.

Nun können Sie die Testfälle starten. Führen Sie hierfür folgenden Befehl aus, um die Testfälle im Selenium-Chrome-Container zu starten:
```bash
$ mvn exec:java -Dexec.mainClass="de.qytera.suite_crm.TestRunner" \
    -Ddriver.name="chrome-remote" \
    -DpageUrl="http://suitecrm:8080" \
    -Ddriver.remoteUrl="http://localhost:4444/wd/hub"
```

Beachten Sie heirbei, dass wir für die URL den Hostnamen `suitecrm` statt `localhost` verwenden. Dies liegt daran, dass die Testfälle im Selenium-Container ausgeführt werden und in diesem `localhost` auf den Container selbst verweist. Somit geben wir als Hostnamen `suitecrm` an, was dem in der Datei `docker-compsose.yml` definierten Containernamen entspricht.
Für den Hostnamen des Treibers können wir weiterhin `localhost`verwenden, da der Maven-Prozess nicht innerhalb eines Docker-Containers läuft.

Möchten Sie mit Firefox anstelle von Chrome testen ändern Sie die Parameter `driver.name` und `driver.remoteUrl` folgendermaßen:

```bash
$ mvn exec:java -Dexec.mainClass="de.qytera.suite_crm.TestRunner" \
    -Ddriver.name="firefox-remote" \
    -DpageUrl="http://suitecrm:8080" \
    -Ddriver.remoteUrl="http://localhost:4445/wd/hub"
```

Sie finden die entsprechenden Befehle auch im Ordner `./scripts/run` in diesem Projekt.

### Container herunterfahren

Sie können die Container mit folgendem Befehl wieder herunterfahren:

```bash
$ docker-compose down
```

## Kubernetes

Öffnen Sie eine Konsole, navigieren Sie zum Stammverzeichnis dieses Projektes un führen Sie anschließend folgenden Befehl aus:

```bash
$ kubectl apply -f k8s
```

Dieser Befeh erstellt die Container, welche in den YAML-Dateien im Ordner `k8s` definiert sind.

### Verwendung unter Windows

Benutzen Sie unter Windows die Kubernetes-Version, welche Sie mittels Docker for Desktop installiert haben, so reicht es nicht aus, die Container nur zu starten. Sie müssen in diesem Fall auch manuell die Portfreigabe durchführen. Um den Datenverkehr von einem Port Ihrer lokalen Maschine an einen Port eines Containers weiterzuleiten geben Sie folgenden Befehl ein:

```
# Allgemein
$ kubectl port-forward deployment/<deployment-name> <local-port>:<container-port>

# Am Beispiel des Selenium-Containers
$ kubectl port-forward deployment/selenium-chrome 4444:4444
```

Es sollte in etwa folgende Ausgabe erscheinen:

```bash
Forwarding from 127.0.0.1:4444 -> 4444
Forwarding from [::1]:4444 -> 4444
```

Beachten Sie, dass Sie für jedes Port-Forwarding eine neue Konsole öffnen müssen. Sie können das Port-Forwarding mittels CTRL+C beenden.

Sie finden die entsprechenden Befehle im Verzeichnis `scripts/k8s/port-forwarding`
Mehr Informationen zum Thema Port-Forwarding finden Sie hier: https://kubernetes.io/docs/tasks/access-application-cluster/port-forward-access-application-cluster/

Sobald die Container laufen können Sie von Ihrer lokalen Maschine aus mit folgendem Befehl die Tests starten:

```
$ mvn exec:java -Dexec.mainClass="de.qytera.suite_crm.TestRunner" \
    -Ddriver.name="chrome-remote" \
    -DpageUrl="http://suitecrm:8080" \
    -Ddriver.remoteUrl="http://localhost:4444/wd/hub"
```

Sie sehen, dass dieser Befehl identisch ist mit dem Befehl, welcher unter Verwendung von `docker-compose` genutzt wurde.