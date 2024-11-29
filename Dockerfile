FROM ghcr.io/graalvm/graalvm-ce:latest

WORKDIR /app
COPY target/bowling.jar bowling.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "bowling.jar"]
