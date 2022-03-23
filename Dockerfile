FROM openjdk:8-jdk-alpine
MAINTAINER experto.com
VOLUME /tmp
EXPOSE 8080
ADD target/demoAuthApi-0.0.1-SNAPSHOT.jar demoAuthApi.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demoAuthApi.jar"]