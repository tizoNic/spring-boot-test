FROM openjdk:11.0.13-slim-buster
VOLUME /tmp
COPY target/apirest-0.0.1-SNAPSHOT.jar apirest-0.0.1-SNAPSHOT.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/apirest-0.0.1-SNAPSHOT.jar"]