package raisinChallenge.raisinAutomation.PagesTest;



import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import raisinChallenge.raisinAutomation.Base.Base;
import raisinChallenge.raisinAutomation.Pages.OfferPages;
import raisinChallenge.raisinAutomation.Screenshot.TakeScreenShot;




@Listeners(raisinChallenge.raisinAutomation.ExtentReportListener.ExtentReportNG.class)
public class OfferPageTest extends Base
{
   OfferPages offerpage;
   
	
    public OfferPageTest()
    {
        super();
    }
    
    @BeforeMethod
	public void setUp() throws Exception {
		initialisation();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("Class OfferPageTest > Before method has been invoked ");
		offerpage = new OfferPages();
		offerpage.ourOfferPage();
	}

    @Test
    public void offerpageTitleTest() throws Exception
    {
  
    	log.info("code came to offerpageTitleTest method of OfferPageTest class");
  String title=offerpage.validatePageTitle();
  Assert.assertEquals(title,prop.getProperty("pagetitle_offerpage"));  
    }
    
    @Test
    public void easyAccessCheckboxTest() throws Exception {
    	log.info("code came to easyAccessCheckboxTest method of OfferPageTest class");
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   
    	offerpage.easyAccessCheckbox();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   
    	System.out.println("Value of Check Box after removing alphabet is:"+offerpage.numericValuefromCheckBox);
    	System.out.println("Value of Blue jar after removing alphabet is:"+offerpage.numericValuefrombluejar);
    	Assert.assertEquals(offerpage.numericValuefromCheckBox, offerpage.numericValuefrombluejar);
    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
    	TakeScreenShot.captureScreenshot(driver,result.getName(),result.getStatus());
    	log.info("code came to After method of OfferPageTest class");
    	driver.quit();
    }
    
}



