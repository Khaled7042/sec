pipeline {
  agent any
  options {
      // Keep the 10 most recent builds
      buildDiscarder(logRotator(numToKeepStr:'10'))
  }
  tools {
      maven 'Maven_3.8.6'
      jdk 'Jdk_11'
  }
  stages {
    stage ('Initialize') {
        steps {
            //echo "${GIT_BRANCH}"
            echo "${env.GIT_BRANCH}"
        }
    }

    stage ('Test') {
          steps {
              bat 'mvn -Dmaven.test.failure.ignore=true test'
          }
          post {
              success {
                  junit 'target/surefire-reports/**/*.xml'
              }
          }
      }

      stage ('Build') {
                steps {
                    bat 'mvn -Dskip.tests=true package'
                }
            }

      stage('Finalize') {
        steps {
          bat 'echo "Finalizing"'
        }
        post{
          always {
           mail bcc: '', body: 'Pipeline has been succesfully executed ', cc: '', from: 'halid-enes.karabiyik@capgemini.com', replyTo: 'halid-enes.karabiyik@capgemini.com', subject: 'Pipeline has been succesfully executed ', to: 'halid-enes.karabiyik@capgemini.com'
          }
        }
      }

  }

}