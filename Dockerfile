#getting base image
FROM java:8
VOLUME /tmp
ADD target/HystrixCB-1.0-SNAPSHOT.jar app.jar
EXPOSE 8081
#EXPOSE 8443
ENTRYPOINT ["java","-jar","/app.jar"]