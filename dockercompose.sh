docker run -d -p 8081:8081 -p 8443:8443 -v $PWD/logs/H1:/logs -e http.port:8081 -e server.port:8443 --name hystrix hystrix:1.0
