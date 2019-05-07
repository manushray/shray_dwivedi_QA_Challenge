package raisinChallenge.raisinAutomation.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import raisinChallenge.raisinAutomation.Base.Base;

import raisinChallenge.raisinAutomation.Utility.UtilUsage;

public class OfferPages extends Base{
	
	public  String numericValuefromCheckBox;
	public  String numericValuefrombluejar;
	
	//Used page Object Model for identifying the elements
	@FindBy(xpath="//a[contains(text(),'Our Offers')]")
	WebElement ourOffers;
	
	@FindBy(name="early_termination")
	WebElement tickeasyaccesscheckbox;
	
	@FindBy(xpath="//label[contains(@class,'label-checkbox ng-binding')]")
	WebElement easyaccesschecboxValue;
	
	@FindBy(xpath="//ng-pluralize[contains(text(),'offers match your search')]")
	WebElement bluebarvalue;
	
	
	//Initializing the Page Object
	public OfferPages() {
		
		PageFactory.initElements(driver, this);//this is pointing to current class object
	}


	
	//our-offer page method
	public void ourOfferPage() throws Exception {
		ourOffers.click();
		driver.manage().timeouts().pageLoadTimeout(UtilUsage.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(UtilUsage.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		log.info("Class Offer Page > loginpage method has been invoked ");
		
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public EasyAccess easyAccessCheckbox() throws InterruptedException {
		tickeasyaccesscheckbox.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String valueCheckBox= easyaccesschecboxValue.getText();
		System.out.println("Value of Check Box is:"+valueCheckBox);
		String bluejarvalue=bluebarvalue.getText();
		System.out.println("Value of Blue jar is:"+bluejarvalue);
		 numericValuefromCheckBox=valueCheckBox.replaceAll("[^0-9]", "");
		
		 numericValuefrombluejar=bluejarvalue.replaceAll("[^0-9]", "");
		return new EasyAccess();
		
	}

}
