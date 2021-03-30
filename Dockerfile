FROM openjdk:15-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} movey-discovery-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/movey-discovery-0.0.1.jar"]