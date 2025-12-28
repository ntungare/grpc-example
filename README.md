# gRPC Example Project

This repository demonstrates a complete gRPC implementation with a shared schema, a server, and multiple clients.

## Project Structure

The project is organized into the following components:

- **[`protos`](./protos)**: Contains the shared Protocol Buffers (`.proto`) definitions. This is the source of truth for the API schema.
- **[`server`](./server)**: A Java + Spring Boot based gRPC server implementation.
- **[`clients`](./clients)**:
  - **[`java`](./clients/java)**: A Java + Spring Boot based gRPC client.
  - **[`node`](./clients/node)**: A Node.js gRPC client.

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java 25**: Required for the server and Java client.
- **Node.js**: Required for the Node.js client (LTS version recommended).
- **pnpm**: Used as the package manager for the Node.js client.

## Getting Started

### Global Build

This project uses the Gradle Wrapper for the Java components. To build the entire project (including protos, server, and Java client):

```bash
./gradlew build
```

### Running Tests

To run unit tests across all Java modules:

```bash
./gradlew test
```

Please refer to the README in each subdirectory for specific instructions on building and running each component.

### Gradle Wrapper

This project uses the Gradle Wrapper. To generate the gradle jar (if missing), run:

```bash
gradle wrapper
```
