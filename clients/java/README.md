# gRPC Java Client

This is a Java + Spring Boot based gRPC client application.

## Features

- **Spring Boot Auto-Configuration**: Automatically configures gRPC clients to communicate with the server.
- **Shared Protos**: Consumes the definitions from the [protos](../../protos) project.
- **Dependency Management**: Uses the project's Gradle build to manage dependencies and proto integration.

## Running the Client

To run the client, use the Gradle wrapper from the root directory:

```bash
./gradlew :clients:java:clean :clients:java:build
```
