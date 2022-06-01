def test(){
    sh 'npm install'
    sh 'npm run test-ci'
}

def testFunctional() {
    sh 'npm install'
    sh 'npm run cypress:ci'
}

def buildAndPushImage(){
withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'USER', passwordVariable: 'PWD')]) {
        sh "docker build . -t $IMAGE_NAME:$IMAGE_TAG"
        sh "echo $PWD | docker login -u $USER --password-stdin"
        sh "docker push $IMAGE_NAME:$IMAGE_TAG"
    }
}

return this