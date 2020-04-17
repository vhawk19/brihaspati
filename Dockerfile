FROM openjdk:8u181-alpine3.8

WORKDIR /

COPY target/uberjar/*-standalone.jar brihaspati.jar
EXPOSE 3000

CMD java -jar brihaspati.jar