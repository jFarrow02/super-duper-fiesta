pipeline {

    agent any

    stages {
        stage("init") {
            steps {
                script {
                    sh 'initializing ...'
                }
            }
        }

        stage("test") {
            steps {
                script {
                    sh "testing..."
                }
            }
        }

        stage("build and push image") {
            steps {
                script {
                    sh 'building and pushing image...'
                }
            }
        }
    }
}