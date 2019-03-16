docker run -d -p 8081:8081 -p 8443:8443 -v $PWD/logs/H1:/logs --name hystrix hystrix:1.0
