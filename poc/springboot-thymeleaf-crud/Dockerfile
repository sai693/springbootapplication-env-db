FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/springboot-thymeleaf-crud-web-app-0.0.1-SNAPSHOT.jar /app/api.jar
COPY src/main/resources/application.properties /app/application.properties
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api.jar"]

