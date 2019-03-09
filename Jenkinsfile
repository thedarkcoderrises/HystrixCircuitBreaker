def containerId=""
pipeline {
    agent none
    stages {
        stage('Build') {
            agent {
                    docker {
                        image 'maven:3-alpine'
                        args '-v /root/.m2:/root/.m2'
                    }
                  }
            steps {
                    sh 'mvn -X clean install -DskipTests'
                  }
            }

        stage('Build DockerImage') {
            agent any
            steps{
                    script{
                        containerId = sh (
                        script :'docker ps -aqf "name=springboot-hystrix"',
                        returnStdout: true
                        ).trim()
                        if("${containerId}"!= ""){
                          sh 'docker stop springboot-hystrix'
                          sh 'docker rm springboot-hystrix'
                          sh 'docker rmi $(docker images --filter=reference=springboot-hystrix --format "{{.ID}}")'
                        }
                    }
                    sh 'docker build -t springboot-hystrix:1.0 .'
                }
         }
        stage('Deployment') {
        agent any
             steps {
                     sh 'sh dockercompose.sh'
                   }
           }
    }
 }