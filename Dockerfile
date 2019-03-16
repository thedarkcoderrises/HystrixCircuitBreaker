#getting base image
FROM java:8
ENV http_port 8080
ENV https_port 8443
VOLUME /tmp
ADD target/HystrixCB-1.0-SNAPSHOT.jar app.jar
EXPOSE ${http_port}
ENTRYPOINT ["java","-jar","-Dserver.port=${https_port}","-Dhttp.port=${http_port}","/app.jar"]