def gv

pipeline {

    agent any

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

        stage("test") {
            steps {
                script {
                    echo "testing..."
                    gv.test()
                }
            }
        }

        stage("build and push image") {
            when {
                env.BRANCH_NAME == 'main'
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