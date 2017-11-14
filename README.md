Java support for libpasta
=========================

This repo produces a self-contained jar file for libpasta.

## Requirements

Currently, only 64-bit linux is supported, but we are aiming to support more
platforms.

Both of the below approaches require `libcrypto.so.1.0.0` usually available through
`libssl` or similar package. The currently required version of GLIBC is 2.14.

## Using libpasta-java

### Precompiled .jar

Download a released jar from [Releases](https://github.com/libpasta/libpasta-java/releases).

Include as usual.

### Steps to produce from source (requires Rust):

 * Sync submodules: `git submodule init && git submodule sync --recursive`
 * Using `pasta-bindings` submodule, produce the java libpasta.so file: `cd pasta-bindings && make java && cd ..`.
 * Move the appropriate file to the maven directory: `mkdir -p src/main/resources/ && cp -r pasta-bindings/java/META_INF src/main/resources/META-INF`
 * Compile the jar: `mvn package`.

### Steps to produce using precompiled library:

 * Get the most recent precompiled library from the pasta-bindings releases [https://github.com/libpasta/pasta-bindings/releases/]
   - e.g. `wget https://github.com/libpasta/pasta-bindings/releases/download/v0.0.4-rc.1/libpasta_jni.x86_64-unknown-linux-gnu.so -O libpasta_jni.so`
 * Move to the appropriate directory: `mkdir -p src/main/resources/META-INF/lib/linux_64/ && mv libpasta_jni.so src/main/resources/META-INF/lib/linux_64/`
 * Compile the jar: `mvn package`.

The resultant jar file should be in target/libpasta-java-{version}-jar-with-dependencies.jar.
