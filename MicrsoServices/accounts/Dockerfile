#Start with a base image containing java run time
FROM openjdk:17-jdk-slim as build

#information
MAINTAINER fmc.com

# Add the application's jar to the container
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT [ "java","-jar","accounts-0.0.1-SNAPSHOT.jar" ] 