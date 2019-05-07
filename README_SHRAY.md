#Steps for How to build and execute the solution/code

# I am using Selenium+JAVA+MAVEN+TESTNG+Log4j2.properties+ExtentReport+log4j2


# Description About Code/Framework :

I have created a partial Automation Framework comprise of (Selenium+ JAVA+ Page Object Model+ TestNG + Extent Report).
 
• "Base" class is Parent of all the classes where Driver initialisation + capabilities are defined which is present under package name "raisinChallenge.raisinAutomation.Base".
• All the application code is present under package: “raisinChallenge.raisinAutomation.Pages”
• Reporting is done by Extent Report whose code is present under package: “raisinChallenge.raisinAutomation.ExtentReportListener”. 
• Test Cases are handled by TestNG and as I have build my code using MAVEN hence its present under “src/test/java”

As I have made my code dynamic from where you can change the parameter and data set/Test scenario by changing in the config.properties file which is present under package name "src/main/java/raisinChallenge/raisinAutomation/Configuration/config.properties”



# No need to change anywhere in the code but if you want to change the test data mention in the code challenge then you can change the data in config.properties which is present in configuration package 

# Total time which code will run  : 3:24min

# Steps to run from command line

1. cd /to path where you want to clone the code.

2. Copy the command and hit it at the terminal:

git clone https://github.com/manushray/shray_dwivedi_QA_Challenge.git

3. cd / to shray_dwivedi_qa-challenge

4. run the below command:

mvn clean install


# Step to run the code from Eclipse

1. Clone the code at your preferred location by entering below command:

git clone https://github.com/manushray/shray_dwivedi_QA_Challenge.git

2. Open the project from Eclipse:

   	 1. Browse the location of the clone project from the eclipse
	 2. Click on the "Import > Maven > Existing Maven Projects > Browse > shray_dwivedi_qa-challenge > Finish".
	 3. Right click on the project > Run As > Maven test
