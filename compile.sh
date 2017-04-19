#!/bin/bash

echo "--- COMPILATION ---"
echo ""

rm -rf out/*
javac9 \
	-d out src/java9/**/**/*.java
