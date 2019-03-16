docker run -d -v $PWD/logs/H1:/logs -e http.port=9081 -e server.port=9443 --name hystrix1 hystrix:1.0

#docker run -d -p 9082:8080 -p 9444:8443 -v $PWD/logs/H2:/logs --log-driver json-file --log-opt max-size=20k --log-opt max-file=3 -e http.port=9082 -e server.port=9444 --name hystrix2 hystrix:1.0
