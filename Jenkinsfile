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
                echo("deploy to qa")
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
                    sh "mvn clean test -Dsurefire.suiteXmlFiles=playwright.testRunner/testngRegression.xml"
                    
                }
            }
        }
        
        
        stage('Publish Extent Report'){
            steps{
                     publishHTML([allowMissing: false,
                                  alwaysLinkToLastBuild: false, 
                                  keepAll: true, 
                                  reportDir: 'build', 
                                  reportFiles: 'TestExecutionReport.html', 
                                  reportName: 'HTML Extent Report', 
                                  reportTitles: ''])
            }
        }
        
        
        
        
    }
}