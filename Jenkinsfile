def gv

pipeline {
    agent any

    parameters {
        choice(
            name: 'VERSION',
            choices: ['1.1.0', '1.2.0', '1.3.0'],
            description: ''
        )
        booleanParam(
            name: 'ExecuteTests',
            defaultValue: true,
            description: ''
        )
    }

    stages {
        stage('Init') {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    gv.BuildApp()
                }
            }
        }

        stage('Test') {
            when {
                expression {
                    params.ExecuteTests
                }
            }
            steps {
                script {
                    gv.TestApp()
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    gv.DeployApp()
                }
            }
        }
    }
}
