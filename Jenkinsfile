pipeline{
  agent any 
  tools {
      maven 'Maven3.8.2'
  }  
  stages { 
      stage('Get maven'){
        steps{
           sh 'mvn --version' 
      }
    }           
  }
}