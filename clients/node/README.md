# gRPC Node.js Client

This is a Node.js-based gRPC client.

## Features

- **Dependencies**:
  - `@grpc/grpc-js`: Pure JavaScript gRPC client implementation.
  - `@bufbuild/protobuf`: Protocol Buffers implementation.
  - `tsup`: Used for bundling/packaging the library.
- **Code Generation**: Uses `@bufbuild/buf` to generate TypeScript types and client stubs from the shared protos.

## Development

### Install Dependencies

```bash
pnpm install
```

### Build

To build the library:

```bash
pnpm run build
```
