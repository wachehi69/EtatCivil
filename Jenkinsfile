pipeline{
  agent any 
  tools {
      maven 'Maven3.8.2'
  }  
  stages { 
      stage ('Echo et test unitaire'){
	      steps {
	         sh 'mvn test'
	         junit 'surefire-reports/**/*.xml' 	       
	      } 
		    
	   }
     stage('Package'){
         steps{
          sh 'mvn  package -DskipTest'        
      }
    }           
  }
}
