# gRPC Example Project

This repository demonstrates a complete gRPC implementation with a shared schema, a server, and multiple clients.

## Project Structure

The project is organized into the following components:

- **[`protos`](./protos)**: Contains the shared Protocol Buffers (`.proto`) definitions. This is the source of truth for the API schema.
- **[`server`](./server)**: A Java + Spring Boot based gRPC server implementation.
- **[`clients`](./clients)**:
  - **[`java`](./clients/java)**: A Java + Spring Boot based gRPC client.
  - **[`node`](./clients/node)**: A Node.js gRPC client.

## Getting Started

Please refer to the README in each subdirectory for specific instructions on building and running each component.

### Gradle Wrapper

This project uses the Gradle Wrapper. To generate the gradle jar (if missing), run:

```bash
gradle wrapper
```
