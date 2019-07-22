FROM openjdk:8-jre

ENTRYPOINT ["java", "-jar", "/app/myservice.jar"]

ARG JAR_FILE
ADD target/${JAR_FILE} /app/myservice.jar
