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
            input {
                message 'Select the environment'
                ok 'Environment selected'
                parameters {
                    choice(
                        name: 'ONE',
                        choices: ['dev', 'stage', 'prod'],
                        description: 'Select deployment environment'
                    )
                    choice(
                        name: 'TWO',
                        choices: ['dev', 'stage', 'prod'],
                        description: 'Select deployment environment'
                    )
                }
            }

            steps {
                script {
                    gv.DeployApp()
                    echo "Deploying to ${ONE}"
                    echo "Deploying to ${TWO}"
                }
            }
        }
    }
}
