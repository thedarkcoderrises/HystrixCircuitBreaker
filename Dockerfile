#getting base image
FROM java:8
ENV https_port 8443
VOLUME /tmp
ADD target/HystrixCB-1.0-SNAPSHOT.jar app.jar
EXPOSE ${https_port}
ENTRYPOINT ["java","-jar","-Dserver.port=${https_port}","/app.jar"]