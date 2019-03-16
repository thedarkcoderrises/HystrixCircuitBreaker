docker run -d -e http.port=9090 -e server.port=9443 -v $PWD/logs/H1:/logs --name hystrix hystrix:1.0
