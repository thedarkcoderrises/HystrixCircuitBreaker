#getting base image
FROM java:8
ENV http_port=8080
ENV https_port=8443
VOLUME /tmp
ADD target/HystrixCB-1.0-SNAPSHOT.jar app.jar
EXPOSE ${http_port}
EXPOSE ${https_port}
ENTRYPOINT ["java","-jar","/app.jar"]