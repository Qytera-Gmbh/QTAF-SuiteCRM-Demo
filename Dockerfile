FROM maven:3.8-openjdk-11 AS builder

WORKDIR /app

COPY ./pom.xml ./

RUN mvn clean install -DskipTests=true

COPY ./ ./

RUN mvn clean package -DskipTests=true


FROM openjdk:13-jdk-alpine3.10

WORKDIR /app

COPY --from=build ./target/app.jar ./app.jar

CMD java -jar app.jar