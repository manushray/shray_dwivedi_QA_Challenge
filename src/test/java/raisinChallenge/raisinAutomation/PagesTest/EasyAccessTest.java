package raisinChallenge.raisinAutomation.PagesTest;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import raisinChallenge.raisinAutomation.Base.Base;
import raisinChallenge.raisinAutomation.Pages.EasyAccess;
import raisinChallenge.raisinAutomation.Pages.OfferPages;
import raisinChallenge.raisinAutomation.Screenshot.TakeScreenShot;

@Listeners(raisinChallenge.raisinAutomation.ExtentReportListener.ExtentReportNG.class)
public class EasyAccessTest extends Base{

OfferPages offerpage;
EasyAccess easyaccess;
   
	
    public EasyAccessTest() 
    {
        super();
        
    }
    
    @BeforeMethod
    public void beforemethod() throws Exception{
    	initialisation();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("Class EasyAccessTest > Before method has been invoked ");
		offerpage = new OfferPages();
		easyaccess=new EasyAccess();
		offerpage.ourOfferPage();
		easyaccess=offerpage.easyAccessCheckbox();
    }
  
    @Test
    public void bankNameWithRegisterNowTest1() throws Exception
    {
    	log.info("code came to bankNameWithRegisterNowTest1 method of EasyAccessTest class");
    String interestRateValue=easyaccess.bankNameEasyAccess(prop.getProperty("company_name1"), prop.getProperty("company_name1_term"));
    Assert.assertEquals(interestRateValue,prop.getProperty("company_name1_interest"));
    String title=easyaccess.validatePageTitle();
    Assert.assertEquals(title,prop.getProperty("invest_now_form"));
    
    }
    
    @Test
    public void bankNameWithRegisterNowTest2() throws Exception
    {
    	log.info("code came to bankNameWithRegisterNowTest2 method of EasyAccessTest class");
    String interestRateValue=easyaccess.bankNameEasyAccess(prop.getProperty("company_name2"), prop.getProperty("company_name2_term"));
    Assert.assertEquals(interestRateValue,prop.getProperty("company_name2_interest"));
    String title=easyaccess.validatePageTitle();
    Assert.assertEquals(title,prop.getProperty("invest_now_form"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
    	TakeScreenShot.captureScreenshot(driver,result.getName(),result.getStatus());
	log.info("code came to After method of EasyAccessTest class");
	driver.quit();
    }
    
   
	
}
