pipeline {
    agent {
        docker {
            image 'maven:3.8.3-openjdk-17'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    stages{

        stage('Package'){
            steps{
                sh 'mvn clean package'
            }
        }

        stage('master only'){
            when {branch 'master'}
            stages {

                stage('Create GitHub Release'){
                    steps{
                        echo 'Create GH Release'
                    }
                }

                stage('Deploy to PRD server'){
                    steps{
                        echo "Deploy to PRD"
                    }
                }
            }
           
        }
    }
}
