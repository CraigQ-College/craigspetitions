pipeline {

    agent any
    tools{
        git 'Default'
    }
    stages {
        stage ('Stage 1: Get the code from GitHub') {
            steps {
                git branch:'master', url:'https://github.com/CraigQ-College/craigspetitions.git'
            }
        }
        stage ('Stage 2: Build') {
            steps {
                sh 'mvn clean:clean'
                sh 'mvn dependency:copy-dependencies'
                sh 'mvn compiler:compile'
            }
        }
        stage ('Stage 3: Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage ('Stage 4: Package & Archive') {
            steps {
                sh 'mvn package'
                archiveArtifacts allowEmptyArchive: true,
                             	artifacts:'**/craigspetitions*.war'
            }
        }
	    stage ('Stage 5: Deploy') {
            steps {
                sh 'docker build -f Dockerfile -t myapp . '
                sh 'docker rm -f "myappcontainer" || true'
                sh 'docker run --name "myappcontainer" -p 9090:8080 --detach myapp:latest'
            }
        }
    }
}