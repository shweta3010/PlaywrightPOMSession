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
           steps{
                echo("Build")
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
                    git 'https://github.com/shweta3010/PlaywrightPOMSession'
                    sh "mvn clean install test -Dsurefire.suiteXmlFiles=playwright.testRunner/testngRegression.xml"
                    
                }
            }
        }
        
        
        stage('Publish Extent Report'){
            steps{
                echo("Report")
            }
        }
        
        
        
        
    }
}