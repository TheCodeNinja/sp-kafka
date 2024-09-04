# Use a base image with Java
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file
COPY target/demo-0.0.1-SNAPSHOT.jar /app/myapp.jar

# Expose the port your app runs on
EXPOSE 8080

# Command to run the app
CMD ["java", "-jar", "myapp.jar"]