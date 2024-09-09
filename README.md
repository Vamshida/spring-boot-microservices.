# spring-boot-microservices.
# Spring Boot Microservices with Kafka Integration

This project contains two Spring Boot microservices for user management and journaling, with event-driven communication via Kafka. The project uses Docker for containerization and includes role-based access control with Spring Security.

## Features
- **User Service**: 
  - Register, update, delete users, and manage user roles.
  - Publishes user events (like registration and deletion) to a Kafka topic.
  - Role-based access control using Spring Security (ADMIN, USER roles).
- **Journal Service**: 
  - Consumes user events from Kafka and logs them.
  - Provides endpoints to retrieve journal entries.
  - Only ADMIN users can access the journal service.
  
- **Kafka Integration**: Kafka is used to handle user events between the services.
- **Docker Compose**: Easily set up and run the whole system using Docker.
  
## Technologies Used
- **Spring Boot**
- **Spring Security** (for role-based access control)
- **Kafka** (for message-driven communication between services)
- **Docker** (for containerization)
- **H2 Database** (in-memory database for local development)
- **JUnit & Mockito** (for testing)

---

## REST API Documentation

### **User Service**

#### Base URL: `/users`

1. **Register a User**
   - **Endpoint**: `/users/register`
   - **Method**: `POST`
   - **Description**: Registers a new user in the system.
   - **Request Body**:
     ```json
     {
       "username": "testUser",
       "password": "password123",
       "role": "ROLE_USER"
     }
     ```
   - **Response**: `201 Created`
     ```json
     {
       "id": 1,
       "username": "testUser",
       "role": "ROLE_USER"
     }
     ```

2. **Get User by ID**
   - **Endpoint**: `/users/{id}`
   - **Method**: `GET`
   - **Description**: Retrieves a user by their ID.
   - **Response**: `200 OK`
     ```json
     {
       "id": 1,
       "username": "testUser",
       "role": "ROLE_USER"
     }
     ```
   - **Errors**: `404 Not Found` if the user doesn't exist.

3. **Update User**
   - **Endpoint**: `/users/{id}`
   - **Method**: `PUT`
   - **Description**: Updates user information.
   - **Request Body**:
     ```json
     {
       "username": "updatedUser",
       "password": "newPassword",
       "role": "ROLE_ADMIN"
     }
     ```
   - **Response**: `200 OK`
     ```json
     {
       "id": 1,
       "username": "updatedUser",
       "role": "ROLE_ADMIN"
     }
     ```

4. **Delete User**
   - **Endpoint**: `/users/{id}`
   - **Method**: `DELETE`
   - **Description**: Deletes a user.
   - **Response**: `204 No Content`

---

### **Journal Service**

#### Base URL: `/journals`

1. **Get All Journals** (Admin Only)
   - **Endpoint**: `/journals`
   - **Method**: `GET`
   - **Description**: Retrieves all journal entries from the system. Only users with the `ROLE_ADMIN` role can access this endpoint.
   - **Response**: `200 OK`
     ```json
     [
       {
         "id": 1,
         "message": "User Registered: testUser"
       },
       {
         "id": 2,
         "message": "User Deleted: 1"
       }
     ]
     ```
   - **Errors**: 
     - `403 Forbidden` if the user is not an admin.

---

### **Authentication**

- **Basic Authentication** is used for API requests.
  - Include the credentials in the request headers:
    ```text
    Authorization: Basic <base64 encoded username:password>
    ```

---

## How to Run the Project

### 1. Prerequisites

- **Docker**: Install Docker from [here](https://docs.docker.com/get-docker/).
- **Kafka**: Kafka will be started automatically with Docker Compose.

### 2. Run the System with Docker Compose

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/spring-boot-microservices.git
   cd spring-boot-microservices
