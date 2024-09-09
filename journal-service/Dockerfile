# Use the official OpenJDK 11 image
FROM openjdk:11-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies (layer caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the entire project to the container
COPY . .

# Package the application
RUN mvn clean package -DskipTests

# Expose the application's port
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "target/journal-service-1.0.0.jar"]
