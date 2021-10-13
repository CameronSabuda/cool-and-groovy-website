pipeline {
    agent any
    environment {
        CI = true
    }
        stages {
            stage('WhereamI') {
                steps {
                    sh 'pwd'
                }
            }
            stage('Install dependencies') {
                steps {
                    sh 'npm install'
                }
            }
            stage('Build') {
                steps {
                    sh 'npm run build'
                }
            }
            stage('Start application') {
                steps {
                    sh 'npm start'
                }
            }
        }
}