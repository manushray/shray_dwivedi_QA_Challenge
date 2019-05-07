package raisinChallenge.raisinAutomation.Pages;


import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import raisinChallenge.raisinAutomation.Base.Base;
import raisinChallenge.raisinAutomation.Utility.UtilUsage;

public class BankMoodyRate extends Base {
	UtilUsage utilusage;
	
	//Used page Object Model for identifying the elements
	@FindBy(xpath="//a[contains(text(),'Banks')]")
	WebElement banklink;
	
	@FindBy(xpath="//a[contains(@class,'bank-product-cta btn btn-primary btn-lg')]")										
	WebElement investnowlink;
	

	
	
	//Initializing the Page Object
	public BankMoodyRate() {
		
		PageFactory.initElements(driver, this);//this is pointing to current class object
	}

	public void banklinkmethod() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		banklink.click();
	}
	
	//bank page method
	public void bankmoodyname() throws Exception {

		  List<WebElement> anchors = driver.findElements(By.className(prop.getProperty("bank_moody_rating_className")));
	      Iterator<WebElement> i = anchors.iterator();
	     
	      while(i.hasNext()) {
	          WebElement anchor = i.next();
	          System.out.println("Moody Rating for the Bank:"+anchor.getText());
	          if(anchor.getText().contains(prop.getProperty("bank_moody_rating"))) {
	        	  anchor.click();
	     /* Used Sibling concept to identify the WebElement that too with dynamic input parameter*/
	        	  WebElement parentclass=anchor.findElement(By.xpath("//span[contains(text(),'"+prop.getProperty("bank_moody_rating")+"')]/ancestor::div[@class='banks-archive-item-inner']//div[1]/div/a"));
	        	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        	  parentclass.click();
	        	  break;
	          }
	  }
		
	}
	
	public void investnowlinkmethod() throws InterruptedException {
	
		investnowlink.click();
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}

}
