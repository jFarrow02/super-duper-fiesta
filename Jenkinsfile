pipeline {

    agent any

    stages {
        stage("init") {
            steps {
                script {
                    echo 'initializing ...'
                }
            }
        }

        stage("test") {
            steps {
                script {
                    echo "testing..."
                }
            }
        }

        stage("build and push image") {
            steps {
                script {
                    echo 'building and pushing image...'
                }
            }
        }
    }
}