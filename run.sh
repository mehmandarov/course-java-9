#!/bin/bash

echo ""
echo "--- LAUNCH ---"
echo ""

# --add-exports-private java.base/java.lang=ALL-UNNAMED
# 	is needed for reflection over String internals in `Compaction`
# -XX:-RestrictReservedStack
#	is needed to unlock stack frame reservation in `ReservingStackAreas`
java9 \
	--class-path out \
	$1
