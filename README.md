Java support for libpasta
=========================

This repo produces a self-contained jar file for libpasta.

Steps to produce:

 * Sync submodules: `git submodule init && git submodule sync --recursive`
 * Using `pasta-bindings` submodule, produce the java libpasta.so file: `cd pasta-bindings && make java && cd ..` (requires Rust).
 * Move the appropriate file to the maven directory: `mkdir -p src/main/resources/ && cp -r pasta-bindings/java/META_INF src/main/resources/META-INF`
 * Compile the jar: `mvn package`.

The resultant jar file should be in target/libpasta-java-{version}-jar-with-dependencies.jar.