# Stage 1: Build the application with Maven
FROM amazoncorretto:17

RUN yum install -y tar which gzip # TODO remove

# common for all images
ENV MAVEN_HOME /usr/share/maven

COPY --from=maven:3.9.4-eclipse-temurin-11 ${MAVEN_HOME} ${MAVEN_HOME}
COPY --from=maven:3.9.4-eclipse-temurin-11 /usr/local/bin/mvn-entrypoint.sh /usr/local/bin/mvn-entrypoint.sh
COPY --from=maven:3.9.4-eclipse-temurin-11 /usr/share/maven/ref/settings-docker.xml /usr/share/maven/ref/settings-docker.xml

RUN ln -s ${MAVEN_HOME}/bin/mvn /usr/bin/mvn

ARG MAVEN_VERSION=3.9.4
ARG USER_HOME_DIR="/root"
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"
ENTRYPOINT ["/usr/local/bin/mvn-entrypoint.sh"]


ARG db_url
ARG db_username
ARG db_password
ENV db_url=${db_url}
ENV db_username=${db_username}
ENV db_password=${db_password}


WORKDIR /workspace
COPY pom.xml /workspace
COPY ./ /workspace
RUN mvn compile
RUN mvn test
RUN mvn package
RUN cat target/classes/application.properties
RUN ls -ltr /workspace/target/
RUN cp /workspace/target/springboot-thymeleaf-crud-web-app-0.0.1-SNAPSHOT.jar ./your-application.jar

# Stage 2: Create the final image with the Java runtime
#FROM amazoncorretto:17
#WORKDIR /workspace
#COPY target/springboot-thymeleaf-crud-web-app-0.0.1-SNAPSHOT.jar ./your-application.jar
CMD ["java", "-jar", "your-application.jar"]

