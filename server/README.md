# gRPC Server

This is a Java-based gRPC server built with Spring Boot.

## Features

- **Spring Boot Integration**: Leverages Spring Boot for configuration, dependency injection, and application lifecycle management.
- **gRPC Implementation**: Implements the service definitions from the [protos](../protos) project.
- **Actuator Endpoints**: Spring Boot Actuator is enabled, exposing web endpoints for examining the application's health, metrics, and other operational information.

## Prerequisites

- **Java 25**: This project utilizes language features from Java 25. Ensure your environment is configured correctly.

## Running the Server

To run the server using Gradle in the main folder:

```bash
./gradlew :server:bootRun
```

### Configuration

The server starts on port **9090** by default.

- **gRPC Port**: 9090
- **Health Check**: Exposed via Spring Boot Actuator.

You can verify the server is running by checking the actuator health endpoint (mapped to HTTP):

```bash
curl http://localhost:8080/actuator/health
```
*(Note: Actuator runs on the standard web port 8080 by default)*

## Testing

To run unit tests using Gradle in the main folder:

```bash
./gradlew :server:test
```
