docker run -d -p 8081:8081 -p 8443:8443 -v $PWD/logs:/logs -v $PWD/hystrix/localmount:/tmp --log-driver json-file --log-opt max-size=20k --log-opt max-file=3 --name hystrix hystrix:1.0

