#getting base image
FROM java:8
ENV http_port 8081
ENV https_port 8443
VOLUME /tmp
ADD target/HystrixCB-1.0-SNAPSHOT.jar app.jar
EXPOSE ${http_port}
EXPOSE ${https_port}
ENTRYPOINT ["java","-jar","-Dhttp.port=${http_port}","-Dserver.port=${https_port}","/app.jar"]