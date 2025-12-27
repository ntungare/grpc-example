#!/usr/bin/env sh

DIR="$( cd "$( dirname "$0" )" && pwd )"

mkdir -p "$DIR/generated"

IN_DIR="$(realpath $DIR/../../proto/src/main/proto)"
OUT_DIR="$(realpath $DIR/generated)"
PROTOC="$(pnpm bin)/grpc_tools_node_protoc"
TS_PLUGIN="$(pnpm bin)/protoc-gen-ts"

echo $IN_DIR
echo $OUT_DIR
echo $PROTOC
echo $TS_PLUGIN

rm -rf $OUT_DIR/*

$PROTOC \
    --proto_path=$IN_DIR \
    --plugin="protoc-gen-ts=$TS_PLUGIN" \
    --js_out="import_style=commonjs,binary:$OUT_DIR" \
    --grpc_out="grpc_js:$OUT_DIR" \
    --ts_out="service=grpc-node,mode=grpc-js:$OUT_DIR" \
    $IN_DIR/hello.proto
