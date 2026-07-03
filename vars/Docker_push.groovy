def call(String Project, String ImageTag) {
    withCredentials([
        usernamePassword(
            credentialsId: 'dockerhubcred',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {
        sh '''
            echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
            docker push $DOCKER_USER/'"${Project}"':'"${ImageTag}"'
        '''
    }
}
