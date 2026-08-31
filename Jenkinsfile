pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Base Image') {
            steps {
                sh 'docker build -t myapp-base:1.0 ./base'
            }
        }

        stage('Build App Image') {
            steps {
                sh 'docker build -t myapp:1.0 ./app'
            }
        }

        stage('Run Container') {
            steps {
                sh '''
                    docker stop myapp-container || true
                    docker rm myapp-container || true
                    docker run -d --name myapp-container -p 8081:8081 myapp:1.0
                '''
            }
        }
    }
}
