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
                        script :'docker ps -aqf "name=hystrix"',
                        returnStdout: true
                        ).trim()
                        if("${containerId}"!= ""){
                          sh 'docker stop hystrix'
                          sh 'docker rm hystrix'
                          sh 'docker rmi $(docker images --filter=reference=hystrix* --format "{{.ID}}")'
                        }
                    }
                    sh 'docker build -t hystrix:1.0 .'
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