# gRPC Java Client

This is a Java + Spring Boot based gRPC client application.

## Features

- **Spring Boot Auto-Configuration**: Automatically configures gRPC clients to communicate with the server.
- **Shared Protos**: Consumes the definitions from the [protos](../../protos) project.
- **Dependency Management**: Uses the project's Gradle build to manage dependencies and proto integration.

## Prerequisites

- **Java 25**: This project utilizes language features from Java 25. Ensure your environment is configured correctly.

## Building

To build the client and run tests using Gradle in the main folder:

```bash
./gradlew :clients:java:build
```

## Running the Client

To run the client application using Gradle in the main folder:

```bash
./gradlew :clients:java:bootRun
```

## Testing

To run unit and integration tests using Gradle in the main folder:

```bash
./gradlew :clients:java:test
```
