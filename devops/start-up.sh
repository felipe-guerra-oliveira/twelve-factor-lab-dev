#!/bin/bash
JAVA_OPTS="-Xms1024m -Xmx1024m -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC"

nohup $JAVA_HOME/bin/java -jar /app/twelve-factor/bin/api-1.0.0.jar $JAVA_OPTS > /var/log/twelve-factor.out
