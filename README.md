# spring-boot-microservices.
# Spring Boot Microservices with Kafka

This project contains two Spring Boot microservices for user management and journaling with Kafka integration.

## Features
- User Service: Register, update, delete users and manage roles.
- Journal Service: Consume user events from Kafka and store logs.
- Role-Based Access Control using Spring Security.
- Docker Compose setup for local development.

## How to Run the Project
1. Ensure Kafka and Zookeeper are running.
2. Run the services using Docker:
   ```bash
   docker-compose up --build
