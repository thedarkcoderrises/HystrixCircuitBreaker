pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build Artifact') {
            steps {
                sh 'mvn -X clean install -DskipTests'
            }
        }
        stage('Build DockerImage') {
            steps{
              script {
                docker build -t springboot-hystrix:1.0+":$BUILD_NUMBER" .
              }
            }
          }
    }
}