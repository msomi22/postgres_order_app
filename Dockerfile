FROM openjdk:8-jdk-alpine
LABEL maintainer="mwendapeter72@gmail.com"
VOLUME /tmp
ADD target/FileAPI-0.0.1-SNAPSHOT.jar FileAPI.jar  
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/.urandom","-jar","FileAPI.jar"]
EXPOSE 8082
