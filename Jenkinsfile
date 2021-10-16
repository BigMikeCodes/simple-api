pipeline {
    agent {
        docker {
            image 'maven:3.8.3-openjdk-17'
            args '-v $HOME/.m2:/root/.m2'
        }
    }

    environment {
        GH_REPO_NAME = 'simple-api'
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
                        withCredentials([usernamePassword(credentialsId: 'GH-RELEASE-USERNAME-ACCESS-KEY', passwordVariable: 'GH_TOKEN', usernameVariable: 'GH_USR_NAME')]){
                            sh '''
                                ./automation/GitHubRelease.sh $GH_USR_NAME $GH_TOKEN $GH_REPO_NAME v0.0.2 
                            '''
                        }
                    }
                }

                stage('Deploy to PRD server'){
                    steps{
                        echo 'Deploy to PRD server'
                    }
                }
            }
           
        }
    }
}
