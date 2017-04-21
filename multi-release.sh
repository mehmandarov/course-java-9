#!/bin/bash

rm -rf out-mr
mkdir -p out-mr/java-8-src
mkdir -p out-mr/java-8
mkdir -p out-mr/java-9-src
mkdir -p out-mr/java-9

echo "compile classes for Java 8"
sed 's/VersionDependent8/VersionDependent/g' \
	src/org/codefx/demo/java9/internal/multi_release/VersionDependent8.java \
	> out-mr/java-8-src/VersionDependent.java
sed 's/VersionDependent8/VersionDependent/g' \
	src/org/codefx/demo/java9/internal/multi_release/Main.java \
	> out-mr/java-8-src/Main.java

echo "TODO: COMPILE THE CLASSES IN out-mr/java-8-src AGAINST JAVA 8"

echo "compile classes for Java 9"
sed 's/VersionDependent9/VersionDependent/g' \
	src/org/codefx/demo/java9/internal/multi_release/VersionDependent9.java \
	> out-mr/java-9-src/VersionDependent.java
echo "TODO: COMPILE THE CLASSES IN out-mr/java-9-src AGAINST JAVA 9"

echo "TODO: PACKAGE AND RUN ON JAVA 8 AND JAVA 9"
