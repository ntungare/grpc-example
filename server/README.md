# gRPC Server

This is a Java-based gRPC server built with Spring Boot.

## Features

- **Spring Boot Integration**: Leverages Spring Boot for configuration, dependency injection, and application lifecycle management.
- **gRPC Implementation**: Implements the service definitions from the [protos](../protos) project.
- **Actuator Endpoints**: Spring Boot Actuator is enabled, exposing web endpoints for examining the application's health, metrics, and other operational information.

## Running the Server

To run the server, use the Gradle wrapper:

```bash
./gradlew :server:bootRun
```
