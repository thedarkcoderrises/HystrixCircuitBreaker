#getting base image
FROM java:8
VOLUME /tmp
ADD target/HystrixCB-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
RUN curl -L https://github.com/docker/compose/releases/download/1.23.2/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose && chmod +x /usr/local/bin/docker-compose
ENTRYPOINT ["java","-jar","/app.jar"]
