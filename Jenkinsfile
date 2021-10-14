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

        stage('Deploy'){
            when {branch 'master'}
            steps {
                echo 'Deploy to host only on master'
            }
        }
    }
}