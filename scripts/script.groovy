def runUnitTests() {
    sh 'npm install'
    sh 'npm test'
}

def buildImage() {
    withCredentials(usernamePassword([credentialsId: 'nexus-creds', usernameVariable: 'USER', passwordVariable: 'PWD'])) {
        sh "docker build -t $IMAGE_NAME ."
        sh "echo $PWD | docker login -u $USER --password-stdin $NEXUS_REPO_IP:$NEXUS_PORT"
        sh "docker push $IMAGE_NAME"
    }
}

return this;