pipeline {
    agent any
    
    tools {
        git 'Default'
    }

    stages {
        stage('GetProject') {
            steps {
                git branch: 'master', url:'https://github.com/CraigQ-College/craigspetitions.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean:clean'
                sh 'mvn dependency:copy-dependencies'
                sh 'mvn compiler:compile'
               }
        }
        stage('Execute') {
            steps {
                sh 'mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"'
            }
        }
    }
}
