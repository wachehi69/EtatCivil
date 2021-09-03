pipeline{
  agent any 
  tools {
      maven 'Maven3.8.2'
  }  
  stages { 
      parallel {
	      stage('Echo'){
	        steps{
	           echo 'Le step de test'
	           sh 'mvn --version'                
	      }
	    }  
	    stage('Test unitaire'){
	        steps{
	          sh 'mvn  test'        
	      }
	    }  
   }
    stage('Package'){
        steps{
          sh 'mvn  package -DskipTest'        
      }
    }           
  }
}