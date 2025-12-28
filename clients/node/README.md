# gRPC Node.js Client

This is a Node.js-based gRPC client.

## Features

- **Dependencies**:
  - `@grpc/grpc-js`: Pure JavaScript gRPC client implementation.
  - `@bufbuild/protobuf`: Protocol Buffers implementation.
  - `tsup`: Used for bundling/packaging the library.

- **Code Generation**: Uses `@bufbuild/buf` to generate TypeScript types and client stubs from the shared protos.

## Prerequisites

- **Node.js**: Latest LTS version recommended.
- **pnpm**: This project uses pnpm for package management.

## Development

### Install Dependencies

```bash
pnpm install
```

### Build

This project uses a two-step build process:
1. **Generate**: Creates TypeScript types from the protos using `buf`.
2. **Library**: Bundles the code using `tsup`.

To run the full build:

```bash
pnpm run build
```

### Running the Client

You can run the trial scripts to verify connectivity:

```bash
# Run CommonJS version
pnpm run trial:cjs

# Run ES Module version
pnpm run trial:esm

# Run this to test both
pnpm run trial
```
