docker run -p 9081:8080 -d -v $PWD/logs/H1:/logs -e http.port=9081 -e server.port=8443 --name hystrix1 hystrix:1.0
