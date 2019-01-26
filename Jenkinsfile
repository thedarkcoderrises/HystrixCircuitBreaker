pipeline {
    agent any
    stages {
        stage('Build Artifact') {
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
            steps{
              echo "build docker image"
            /* sh 'docker build -t springboot-hystrix:1.0.${BUILD_NUMBER} .' */
            }
         }
         /*stage('Deploy DockerImage') {
             steps{
               sh 'docker run -d -p 8081:8080 -v /home/ec2-user/myDocker/springboot-hystrix/localmount:/tmp --name springboot-hystrix springboot-hystrix:1.0.${BUILD_NUMBER}'
             }
          }
          */
          stage('Remove Dangling Images'){
            steps{
                /*sh 'docker rmi $(docker images -qa -f dangling=true)'*/
               sh 'docker rmi 6ecd959f1108'
               sh 'docker rmi 6ecd959f1108'
            }
          }

    }
}