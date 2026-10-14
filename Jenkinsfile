
pipeline{
    agent any
    stages{
        stage("test"){
            steps{
                script{
                    echo "testing the application"
                }
            }
        }
        stage("build"){
            steps{
                script{
                    echo "building the application"
                }
            }
        }
        stage("deploy"){
            steps{
                script{
                    def dockerCmd = 'docker run -p 8080:8080 -d sivabonu81/java-maven-app:jma-1.0'
                    sshagent(credentials: ['ec2-credentials']) {
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@13.204.65.92 '${dockerCmd}'"
                    }
                }
            }
        }
    }
}
