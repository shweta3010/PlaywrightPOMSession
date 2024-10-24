pipeline 
{
    agent any
    
    tools{
    	maven 'Maven-3.9.9'
        }

    stages 
    {
        stage('Build') 
        {
            steps
            {
                echo("deploy to build")
            }
           
        }
        
        
        
        stage("Deploy to QA"){
            steps{
                echo("deploy to qa")
            }
        }
                
        stage('Regression Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
					echo("deploy to regression")
					sh "git --version"
                    git 'https://github.com/shweta3010/PlaywrightPOMSession'
                    sh "mvn clean test -Dsurefire.suiteXmlFiles=playwright.testRunner/testngRegression.xml"
                    
                }
            }
        }
        
        
        stage('Publish Extent Report'){
            steps{
                     echo("deploy to report")
            }
        }
        
        
        
        
    }
}