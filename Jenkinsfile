def gv

pipeline {

    agent {
        docker {
            image 'cypress/base'
        }
    }

    environment {
        IMAGE_NAME = 'jfarrow02/restaurant-finder'
        IMAGE_TAG = '0.2'
    }

    stages {
        stage("init") {
            steps {
                script {
                    echo 'initializing ...'
                    gv = load "./script.groovy"
                }
            }
        }

        stage("unit test") {
            steps {
                script {
                    echo "running unit tests..."
                    gv.test()
                }
            }
        }

        stage("functional test") {
            steps {
                script {
                    echo "running functional tests..."
                    gv.testFunctional()
                }
            }
        }

        stage("build and push image") {
            when {
                expression {
                    env.BRANCH_NAME == 'main'
                }
            }

            steps {
                script {
                    echo 'building and pushing image...'
                    gv.buildAndPushImage()
                }
            }
        }
    }
}