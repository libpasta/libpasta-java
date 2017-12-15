JAR_URL = $(shell curl -s "https://api.github.com/repos/libpasta/libpasta-java/releases/latest" \
    | jq -r '.assets[] | select(.name=="libpasta-java.x86_64-unknown-linux-gnu.jar") | .browser_download_url')
SO_URL = $(shell curl -s "https://api.github.com/repos/libpasta/pasta-bindings/releases/latest" \
    | jq -r '.assets[] | select(.name=="libpasta_jni.x86_64-unknown-linux-gnu.so") | .browser_download_url')


all: mvn

get-precompiled:
	wget $(JAR_URL)

libpasta-sync:
	git submodule update --init --recursive
ifneq ($(shell git -C pasta-bindings/ rev-parse --abbrev-ref HEAD),master)
	cd pasta-bindings && git fetch && git checkout origin/master
endif
	make -C pasta-bindings libpasta-sync

using-systemlib: libpasta-sync
	make -C pasta-bindings java
	make mvn

using-staticlib: USE_STATIC=1
using-staticlib using-sharedlib: libpasta-sync
	USE_STATIC=$(USE_STATIC) make -C pasta-bindings libpasta java
	make mvn

using-precompiled:
	wget $(SO_URL) -O libpasta_jni.so
	make mvn

mvn:
	mkdir -p src/main/resources/
	cp -r pasta-bindings/java/META-INF src/main/resources/META-INF
	mvn package

