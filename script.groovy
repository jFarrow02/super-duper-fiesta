def init() {

}

def test(){
    sh 'npm run test'
}

def buildAndPushImage(){
withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'USER', passwordVariable: 'PWD')]) {
        sh "docker build . -t $IMAGE_NAME:$IMAGE_TAG"
        sh "echo $PWD | docker login -u $USER --password-stdin"
        sh "docker push $IMAGE_NAME:$IMAGE_TAG"
    }
}

return this