pipeline{
  agent any 
  tools {
      maven 'Maven3.8.2'
  }  
  stages { 
      stage('Test unitaire'){
        steps{
           echo 'Le step de test'
           sh 'mvn --version' 
           sh 'mvn  test' 
           
      }
    }           
  }
}