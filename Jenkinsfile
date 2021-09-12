node{
   def app 
  tools {
      maven 'Maven3.8.2'
  }  
     stage ('Clone'){
	      checkout scm      	     	    
	   }
     stage('Build image'){
      app = docker.build("xavki/nginx)     
     }
     
      stage('Test image'){
      docker.image('xavki/nginx').winthRun('-p 80:80') { c ->
      sh 'docker ps'
      sh 'curl localhost'
      }     
     }
          
  }
