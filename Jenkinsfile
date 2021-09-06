pipeline{
  agent any 
  tools {
      maven 'Maven3.8.2'
  }  
  
  stages { 
      stage ('Echo et test unitaire'){
	      steps {
	         sh 'mvn test'	            
	      }      	     	    
	   }
     stage('Package'){
         steps{
          sh 'mvn  package -DskipTest'              
         }
            
      }      
    }
       post {
	        always {
	           junit 'target/surefire-reports/*.xml' 	
	           archiveArtifacts artifacts: 'target/*.jar'	         
	         }
	      }          
  }
