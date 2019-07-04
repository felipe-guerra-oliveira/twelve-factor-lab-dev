#!/bin/sh

# Fonte: http://www.jcgonzalez.com/ubuntu-16-java-service-wrapper-example
SERVICE_NAME=TwelveFactorApi
PATH_TO_JAR=/app/twelve-factor/bin/api-1.0.0.jar
PID_PATH_NAME=/tmp/TwelveFactorApi-pid

case $1 in
    start)
        echo "Starting $SERVICE_NAME ..."
        if [ ! -f $PID_PATH_NAME ]; then
            nohup $JAVA_HOME/bin/java -jar $PATH_TO_JAR >> /var/log/twelve-factor-api.out 2>&1&
                        echo $! > $PID_PATH_NAME
            echo "$SERVICE_NAME started ..."
        else
            echo "$SERVICE_NAME is already running ..."
        fi
    ;;
    stop)
        if [ -f $PID_PATH_NAME ]; then
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stoping ..."
            kill $PID;
            echo "$SERVICE_NAME stopped ..."
            rm $PID_PATH_NAME
        else
            echo "$SERVICE_NAME is not running ..."
        fi
    ;;
    restart)
        if [ -f $PID_PATH_NAME ]; then
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stopping ...";
            kill $PID;
            echo "$SERVICE_NAME stopped ...";
            rm $PID_PATH_NAME
            echo "$SERVICE_NAME starting ..."
            nohup $JAVA_HOME/bin/java -jar $PATH_TO_JAR >> /var/log/twelve-factor-api.out 2>&1&
                        echo $! > $PID_PATH_NAME
            echo "$SERVICE_NAME started ..."
        else
            echo "$SERVICE_NAME is not running ..."
        fi
    ;;
esac
