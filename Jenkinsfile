def containerId=""
pipeline {
    agent any
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
             steps {
                     sh 'pwd'
                     sh 'ls -ltr'
                     sh 'docker-compose -version'
                     sh 'docker-compose -f docker-compose.yml up --force-recreate --abort-on-container-exit''
                   }
           }
        stage('Publish Image') {
           steps {
                sh 'docker commit $(docker ps -aqf "name=springboot-hystrix") thedarkcoderrises/springboot-hystrix:1.0.${BUILD_NUMBER}'
               withDockerRegistry([ credentialsId: "thedarkcoderrises-dockerhub", url: "" ]) {
                 sh 'docker push thedarkcoderrises/springboot-hystrix:1.0.${BUILD_NUMBER}'
               }
                sh 'docker rmi $(docker images --filter=reference=thedarkcoderrises/springboot-hystrix:1.0.${BUILD_NUMBER} --format "{{.ID}}")'
            }
        }
    }
 }