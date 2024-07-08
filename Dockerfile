FROM openjdk:21-jdk-slim

LABEL authors="anverbogatov.ru"
MAINTAINER anverbogatov.ru

COPY build/libs/observability-research-0.0.1-SNAPSHOT.jar observability-research-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/observability-research-0.0.1-SNAPSHOT.jar"]