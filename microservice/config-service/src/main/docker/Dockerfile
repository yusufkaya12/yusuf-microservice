FROM openjdk:17.0.1-jdk-slim

RUN apt-get update && apt-get install -y curl

ARG JAR_FILE=target/*.jar
VOLUME /app
COPY ${JAR_FILE} app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
