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
                    steps {
                        withCredentials([usernamePassword(credentialsId: 'GH-RELEASE-USERNAME-ACCESS-KEY', passwordVariable: 'GH_PW', usernameVariable: 'GH_USR_NAME')]){
                            echo '$GH_PW'
                            echo '$GH_USR_NAME'
                        }
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
