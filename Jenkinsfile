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
              sh 'docker build -t springboot-hystrix:1.0.${BUILD_NUMBER} .'
            }
          }
    }
}