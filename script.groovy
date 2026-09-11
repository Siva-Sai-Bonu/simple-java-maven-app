def BuildApp() {
    echo 'Building the application'
}

def TestApp() {
    echo 'Testing the application'
}

def DeployApp() {
    echo 'Deploying the application'
    echo "Deploying version ${params.VERSION}"
}

return this
