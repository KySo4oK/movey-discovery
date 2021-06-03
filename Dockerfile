FROM adoptopenjdk:15-jdk
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} movey-discovery-0.0.3.jar
ENTRYPOINT ["java", "-jar", "/movey-discovery-0.0.3.jar"]