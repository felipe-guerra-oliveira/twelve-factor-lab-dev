#!/bin/bash

JAVA_OPTS="-Xms1024m -Xmx1024m"

$JAVA_HOME/bin/java -jar ./target/api-1.0.0.jar $JAVA_OPTS