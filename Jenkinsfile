pipeline {
    agent any
    tools{
        git 'Default'
    }
    stages {
        stage ('Stage 1: Get the Project') {
            steps {
                git branch:'master', url:'https://github.com/CraigQ-College/CT5171_Assignment_1.git'
            }
        }
        stage ('Stage 2: Build the Project') {
            steps {
                sh 'mvn clean:clean'
            }
        }
        stage ('Stage 3: Package the Project') {
            steps {
                sh 'mvn package'
            }
        }
	stage ('Stage 4: Archive the Project') {
            steps {
                archiveArtifacts allowEmptyArchive: true,
             	artifacts:'**/demo*.war'
            }
        }
	stage ('Stage 5: Deploy the Project') {
            steps {
                sh 'docker build -f Dockerfile -t myapp . '
                sh 'docker rm -f "myappcontainer" || true'
                sh 'docker run --name "myappcontainer" -p 8081:8080 --detach myapp:latest'
            }
        }
    }
}