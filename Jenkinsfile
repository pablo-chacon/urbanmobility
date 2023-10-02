pipeline {
    agent any

    stages {
        stage('Pull Code') {
            steps {
                git 'https://github.com/pablo-chacon/urbanmobility/'
            }
        }

        stage('Development Tests') {
            steps {
                // Run dev env tests.
                sh 'mvn test'
            }
        }

        stage('Production Tests and Deployment') {
            steps {
                // Run prod env tests.
                sh 'mvn test'

                // Build, deploy artifact in prod env.
                sh 'mvn package'
                sh 'java -jar target/maasfp.jar'
            }
        }
    }
}