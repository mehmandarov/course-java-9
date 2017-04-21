#!/bin/bash

echo " > creating clean directories"
rm -rf out/classes
mkdir -p out/classes
rm -rf out/mods
mkdir -p out/mods

echo " > compiling and packaging logger"
mkdir out/classes/logger
javac9 -d out/classes/logger src-logging/java9/jvm/platform_logging/logger/*.java
jar9 --create --file out/mods/logger.jar -C out/classes/logger/ .

echo " > compiling and packaging app"
mkdir out/classes/app
javac9 -d out/classes/app src-logging/java9/jvm/platform_logging/app/*.java
jar9 --create --file out/mods/app.jar --main-class java9.jvm.platform_logging.app.LoggingApplication -C out/classes/app/ .

echo " > running App"
java9 -verbose:gc -p out/mods -m app
