pipeline {
    agent {
        docker {
            image 'maven:3.8.5-openjdk-17'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
    }
}
