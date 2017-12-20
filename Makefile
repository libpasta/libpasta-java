JAR_URL = $(shell curl ${TRAVIS_GITHUB_CREDENTIALS} -s "https://api.github.com/repos/libpasta/libpasta-java/releases/latest" \
    | jq -r '.assets[] | select(.name=="libpasta-java.x86_64-unknown-linux-gnu.jar") | .browser_download_url')
SO_URL = $(shell curl ${TRAVIS_GITHUB_CREDENTIALS} -s "https://api.github.com/repos/libpasta/pasta-bindings/releases/latest" \
    | jq -r '.assets[] | select(.name=="libpasta_jni.x86_64-unknown-linux-gnu.so") | .browser_download_url')


all: mvn

clean:
	make -C pasta-bindings clean
	rm -rf src/main/resources
	mvn clean

get-precompiled:
	wget $(JAR_URL)

libpasta-sync:
	git submodule update --init
ifneq ($(shell git -C pasta-bindings/ rev-parse --abbrev-ref HEAD),master)
	cd pasta-bindings && git fetch --all && git checkout origin/master
endif
	make -C pasta-bindings libpasta-sync

using-systemlib: libpasta-sync
	make -C pasta-bindings java
	make mvn

using-staticlib: USE_STATIC=1
using-staticlib using-sharedlib:
	USE_STATIC=$(USE_STATIC) make -C pasta-bindings libpasta java
	make mvn

using-precompiled:
	mkdir -p pasta-bindings/java/META-INF/lib/linux_64
	wget $(SO_URL) -O pasta-bindings/java/META-INF/lib/linux_64/libpasta_jni.so
	make mvn

update-sources: libpasta-sync
	mkdir -p src/main/java/io/github/libpasta/
	make -C pasta-bindings java
	cp pasta-bindings/java/*.java src/main/java/io/github/libpasta/

mvn:
	mkdir -p src/main/resources/
	cp -r pasta-bindings/java/META-INF src/main/resources/
	mvn -X package

