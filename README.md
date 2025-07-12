# Blogging Platform - Microservices Backend

This is a backend for a blogging platform that I've built using Spring Boot with a complete microservices architecture. The core services include post creation, comments, likes, and notifications. Everything is routed through an API Gateway, and Eureka is used for service discovery. Kafka is used for async communication between services.

---

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Cloud (Eureka, Gateway, FeignClient)
- Kafka
- MySQL
- Swagger (OpenAPI 3)
- Docker Compose (for MySQL and Kafka)

---

## Services Overview

| Service               | Port  | Description                               |
|------------------------|-------|-------------------------------------------|
| eureka-server          | 8761  | Service discovery                         |
| api-gateway            | 8080  | Entry point for all external requests     |
| post-service           | 8081  | Handles CRUD operations for posts         |
| comment-service        | 8082  | Add/fetch comments for a post, validates postId via Feign |
| like-service           | 8084  | Allows users to like posts (Kafka producer) |
| notification-service   | 8085  | Consumes events and logs notification actions |

---

## Features

- Microservice communication using Feign
- Kafka for asynchronous events (like → notification)
- Validates post existence in comment service
- API Gateway for routing all traffic
- Swagger integrated into each service
- Postman workspace available for testing APIs
- No frontend or auth-service added (not needed for this project)

---

## How to Run

1. Start Kafka and MySQL using Docker Compose:

```bash
docker-compose up -d
```

2. Start all services in this order:

- eureka-server
- post-service
- comment-service
- like-service
- notification-service
- api-gateway

3. Access Eureka Dashboard:

```
http://localhost:8761
```

4. Test APIs via Postman:

```
http://localhost:8080
```
