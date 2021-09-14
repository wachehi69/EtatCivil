FROM openjdk:8
MAINTAINER wachehi (wachehi@hotmail.com)
ADD ./target/GestionMairieComores-0.0.1-SNAPSHOT.jar  /etatcivil/GestionMairieComores-0.0.1-SNAPSHOT.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar", "/etatcivil/GestionMairieComores-0.0.1-SNAPSHOT.jar"]