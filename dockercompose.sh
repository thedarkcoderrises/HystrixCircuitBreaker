docker run -d -p 9081:8080 -p 9443:8443 -v $PWD/H1/logs:/logs --log-driver json-file --log-opt max-size=20k --log-opt max-file=3 --name hystrix1 hystrix:1.0
docker run -d -p 9082:8080 -p 9444:8443 -v $PWD/H2/logs:/logs --log-driver json-file --log-opt max-size=20k --log-opt max-file=3 --name hystrix2 hystrix:1.0
