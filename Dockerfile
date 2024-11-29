FROM openjdk:21-jdk
# Add other instructions here...

WORKDIR /app
COPY target/bowling.jar bowling.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "bowling.jar"]
