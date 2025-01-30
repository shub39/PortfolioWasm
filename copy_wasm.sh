#!/bin/bash

SOURCE_DIR="composeApp/build/dist/wasmJs/productionExecutable"
DEST_DIR="site"

echo "Building Wasm project..."
./gradlew wasmJsBrowserDistribution || { echo "Build failed!"; exit 1; }

if [ -d "$SOURCE_DIR" ]; then
    echo "Copying files from $SOURCE_DIR to $DEST_DIR..."

    mkdir -p "$DEST_DIR"

    cp -r "$SOURCE_DIR"/* "$DEST_DIR"

    echo "Copy completed successfully!"
else
    echo "Error: $SOURCE_DIR does not exist. Build might have failed."
    exit 1
fi