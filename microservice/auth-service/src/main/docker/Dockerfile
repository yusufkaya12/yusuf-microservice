FROM openjdk:17.0.1-jdk-slim

ARG JAR_FILE=target/*.jar
VOLUME /app
COPY ${JAR_FILE} app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
