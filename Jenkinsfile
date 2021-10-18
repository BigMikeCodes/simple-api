pipeline {
    agent {
        docker {
            image 'maven:3.8.3-openjdk-17'
            args '-v $HOME/.m2:/root/.m2'
        }
    }

    environment {
        GH_REPO_NAME = 'simple-api'
        POM_VERSION = readMavenPom().getVersion()
    }

    stages{

        stage('Package'){
            steps{
                echo 'mvn package (removed this until mvn cache is setup)'
            }
        }

        stage('master only'){
            when {branch 'master'}
            stages {

                stage('Create GitHub Release'){
                    steps {
                        withCredentials([usernamePassword(credentialsId: 'GH-RELEASE-USERNAME-ACCESS-KEY', passwordVariable: 'GH_TOKEN', usernameVariable: 'GH_USR_NAME')]){
                            sh '''
                                ./automation/GitHubRelease.sh $GH_USR_NAME $GH_TOKEN $GH_REPO_NAME $POM_VERSION
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

        stage('feature to dev pr'){
            when {
                changeRequest target: 'dev'
                // branch pattern: "feature/[a-zA-Z_0-9]+", comparator: "REGEXP"
            }
            stages {
                stage('Code Quality'){
                    steps{
                        echo 'run some code quality tool...'
                    }
                }
            }

        }
    }
}
