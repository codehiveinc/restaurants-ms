pipeline {
    agent any

    stages {
        stage('Initialize') {
            steps {
                script {
                    def dockerHome = tool 'myDocker'
                    env.PATH = "${dockerHome}/bin:${env.PATH}"
                    // print the docker location
                    sh 'which docker'
                }
            }
        }

        stage('Clean old containers') {
            steps {
                script {
                    sh 'docker stop restaurants-ms-container || true'
                    sh 'docker rm restaurants-ms-container || true'
                }
            }
        }

        stage('Build and Run Docker') {
            steps {
                script {
                    sh 'docker build -t restaurants-ms .'
                    sh 'docker run -d -p 9090:9090 --name restaurants-ms-container ' +
                            'restaurants-ms'
                }
            }
        }
    }
}