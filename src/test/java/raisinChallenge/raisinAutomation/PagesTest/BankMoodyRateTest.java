package raisinChallenge.raisinAutomation.PagesTest;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import raisinChallenge.raisinAutomation.Base.Base;
import raisinChallenge.raisinAutomation.Pages.BankMoodyRate;

import raisinChallenge.raisinAutomation.Pages.OfferPages;
import raisinChallenge.raisinAutomation.Screenshot.TakeScreenShot;
import raisinChallenge.raisinAutomation.Utility.UtilUsage;

@Listeners(raisinChallenge.raisinAutomation.ExtentReportListener.ExtentReportNG.class)
public class BankMoodyRateTest extends Base {
	
	BankMoodyRate bankmoodyRate;
	OfferPages offerpage;
	   
		@BeforeClass
	    public void BankMoodyRateTestBeforeMethod() throws Exception 
	    {	
	    	initialisation();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			log.info("Class BankMoodyTest > Before method has been invoked ");
			bankmoodyRate= new BankMoodyRate();
			offerpage=new OfferPages();
			bankmoodyRate.banklinkmethod();
	        
	    }
	   
	    
	    @Test
	    public void bankNameMoody() throws Exception {
	    	log.info("code came to bankNameMoody method of BankMoodyRateTest class");
	    	bankmoodyRate.bankmoodyname();
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    }
	    
	    @Test
	    public void investNowFormTest() throws Exception {
	    	log.info("code came to investNowFormTest method of BankMoodyRateTest class");
	    	bankmoodyRate.bankmoodyname();
	    	bankmoodyRate.investnowlinkmethod();
	    	String title=offerpage.validatePageTitle();
	    	driver.manage().timeouts().pageLoadTimeout(UtilUsage.implicit_wait, TimeUnit.SECONDS);
	    	Assert.assertEquals(title,prop.getProperty("invest_now_form"));
	    	
	    }
	    
	    @AfterMethod
	    public void tearDown(ITestResult result) {
	    	TakeScreenShot.captureScreenshot(driver,result.getName(),result.getStatus());
		log.info("code came to After method of BankMoodyRateTest class");
	    	
	    }
	    
	    @AfterClass
	    public void tearDownClass() {
	    	
	    	driver.quit();
	    }
	
}
