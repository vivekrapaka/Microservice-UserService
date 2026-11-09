
pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out source code'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building Spring Boot application'
                sh 'chmod +x gradlew'
                sh './gradlew clean bootJar -x test'
            }
        }

        stage('Verify Artifact') {
            steps {
                echo 'Checking generated JAR'
                sh 'ls -lh build/libs/'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }

        failure {
            echo 'Pipeline failed. Check the console output.'
        }
    }
}
