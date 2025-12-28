# Protos

This directory contains the shared Protocol Buffers (`.proto`) definitions for the project. These files define the service contracts and data structures used by both the server and clients.

## Features

- **Centralized Schema**: Serves as the single source of truth for the API.
- **Java Type Generation**: This project is configured to automatically generate Java types from the `.proto` files, which are then consumed by the Java server and client modules.
- **Cross-Language Support**: The definitions here are also used to generate code for other languages, such as Node.js (via the `clients/node` project).

## Code Generation

This project does not require you to manually generate code.

- **Java**: The Gradle build automatically generates Java sources from the `.proto` files during the build phase (`./gradlew build`).
- **Node.js**: The Node client uses `buf` to generate TypeScript types (`pnpm run build:generate`).
