pipeline {
  agent {
    docker {
      image 'maven:3.8.5-openjdk-17'
    }
  }

  environment {
    IMAGE_NAME = 'riski191203/mybank'
    IMAGE_TAG = 'latest'
  }

  stages {
    stage('Checkout') {
      steps {
        git 'https://github.com/Riskihidayatt/Test-myBank.git'
      }
    }

    stage('Build Spring Boot') {
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }

    stage('Build Docker Image') {
      steps {
        sh "docker build -t $IMAGE_NAME:$IMAGE_TAG ."
      }
    }

    stage('Push Docker Image') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
          sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
          sh "docker push $IMAGE_NAME:$IMAGE_TAG"
        }
      }
    }

    stage('Deploy to Kubernetes') {
      steps {
        sh 'kubectl apply -f deployment.yaml'
        sh 'kubectl apply -f service.yaml'
        sh 'kubectl apply -f ingress.yaml'
      }
    }
  }
}
