#getting base image
FROM java:8
VOLUME /tmp
ADD target/HystrixCB-1.0-SNAPSHOT.jar app.jar
ENV http.port 8080
ENV server.port 8443
EXPOSE ${http.port}
EXPOSE ${server.port}
ENTRYPOINT ["java","-jar","/app.jar"]