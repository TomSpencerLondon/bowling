# Use Amazon Corretto JDK 21 for Java 21
FROM amazoncorretto:21

# Set working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/your-app-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (used by the Spring Boot app)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
