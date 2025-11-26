pipeline {
    agent any

    stages {
        stage('Fetcing code from Git') {
            steps {
               git credentialsId: '2e6e1783-4b9e-4a31-8ddd-a0a47a1b6794', url: 'https://github.com/AtulMhatre/CompleteBDDFramework.git'
            }
        }
		stage('Execution code on Chrome') {
            steps {
                bat "mvn -Dmaven.test.failure.ignore=true -DcliBrowser=Chrome test"
            }

        }
		stage('Execution code on Firefox') {
            steps {
                bat "mvn -Dmaven.test.failure.ignore=true -DcliBrowser=Firefox test"
            }

        }


		stage('Email send to particlpent') {
            steps {
                echo 'Email Sent'
            }
        }
    }
}