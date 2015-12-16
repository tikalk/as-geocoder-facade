# FleetTracker Geo Coder Facade

This microservice is acts as a proxy/facade to GeoCoders. We currentluy use Google. It caches results on Redis.

## How to build
_______________
From the project home folder run the following command:

./gradlew clean build -x test

This will create self contained zip, that you can unzip on host container. The output zip is located at
as-geocoder-facade/build/distributions/as-geocoder-facade.zip 

## How to run
-----------
You must run Redis and have the user and schema according to the config file.

Unzip the file as-managemet/build/distributions/as-geocoder-facade.zip  
cd to the created folder (as-geocoder-facade)
Run the following command : 
./run-bin/geocoder-facade.sh









 

