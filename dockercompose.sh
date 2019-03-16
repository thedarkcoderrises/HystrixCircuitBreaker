docker run -d -p 9081:80 -p 9443:443 -v $PWD/H1/logs:/logs --log-driver json-file --log-opt max-size=20k --log-opt max-file=3 --name hystrix1 hystrix:1.0
