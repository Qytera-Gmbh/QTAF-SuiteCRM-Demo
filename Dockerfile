FROM openjdk:13-jdk-alpine3.10

WORKDIR /app

COPY ./target/SuiteCRMTestProject-1.0-SNAPSHOT-jar-with-dependencies.jar ./app.jar

CMD java -jar app.jar