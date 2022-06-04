def runUnitTests() {
    sh 'npm install'
    sh 'npm test'
}

def buildImage() {
    withCredentials([usernamePassword(credentialsId: 'nexus-creds', usernameVariable: 'USER', passwordVariable: 'PWD')]) {
        sh "docker build -t $IMAGE_NAME ."
        // sh "echo $PWD | docker login -u $USER --password-stdin $NEXUS_REPO_IP"
        sh "docker login -u $USER -p $PWD $NEXUS_REPO_IP"
        sh "docker push $IMAGE_NAME"
    }
}

return this;