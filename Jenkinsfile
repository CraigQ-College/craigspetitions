pipeline {
    agent any
    tools{
        git 'Default'
    }
    stages {
        stage ('GetProject') {
            steps {
                git branch:'main', url:'https://github.com/CraigQ-College/CT5171-MavinTest1.git'
            }
        }
        stage ('build') {
            steps {
                sh 'mvn clean:clean'
                sh 'mvn dependency:copy-dependencies'
                sh 'mvn compiler:compile'
            }
        }
        stage ('test') {
            steps {
                sh 'mvn test:test'
            }
        }
        stage ('Package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('Execute') {
            steps {
                sh 'mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8082"'
            }
        }
    }
    post{
     success{
         archiveArtifacts allowEmptyArchive: true,
             artifacts:'**/craigspetitions*.war'
     }
    }
}


