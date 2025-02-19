pipeline {
    agent any

    stages {
        stage('Unit Test') {
            steps {
                echo 'Using TestNG'
            }
        }
        stage('Static Analysis') {
            steps {
                echo 'Using Sonar Qube'
            }
        }
        stage('Generate Build') {
            steps {
                echo 'Using Maven'
            }
        }
        stage('Execute Regression Tests') {
            steps {
                echo 'Using Selenium , Rest Assured'
            }
        }
    }
}
