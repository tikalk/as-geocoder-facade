#!/bin/bash

echo "Starting AngelSense Geocoder Facade"

DIRNAME=`dirname $0`
APP_HOME=`cd $DIRNAME/..;pwd;`
export APP_HOME;

java -jar $APP_HOME/build/libs/as-geocoder-facade.jar