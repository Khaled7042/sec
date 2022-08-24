pipeline {
  agent any
  stages {
    stage('jenkinsFile') {
      agent any
      environment {
        jenkins = '11'
      }
      steps {
        echo 'Hello Jenkins'
        echo 'this is the second step'
      }
    }

  }
  environment {
    jenkins = '11'
  }
}