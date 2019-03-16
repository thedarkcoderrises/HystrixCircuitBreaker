#getting base image
FROM java:8
ENV http_port 8080
VOLUME /tmp
ADD target/HystrixCB-1.0-SNAPSHOT.jar app.jar
EXPOSE ${http_port}
ENTRYPOINT ["java","-jar","-Dserver.port=${http_port}","/app.jar"]