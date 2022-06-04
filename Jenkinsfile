def gv

pipeline {

    agent any

    environment {
        NEXUS_REPO_IP = '18.206.201.95'
        NEXUS_PORT = '8083'
        IMAGE_NAME = "${NEXUS_REPO_IP}:${NEXUS_PORT}/restaurant-finder:0.1"
    }

    stages {
        stage("init") {
            steps {
                script {
                    echo 'initializing...'
                    gv = load './scripts/script.groovy'
                }
            }
        }

        stage("test") {
            steps {
                script {
                    echo 'testing...'
                    gv.runUnitTests()
                }
            }
        }

        stage("build image") {
            steps {
                script {
                    echo 'building image...'
                    gv.buildImage()
                }
            }
        }
    }
}