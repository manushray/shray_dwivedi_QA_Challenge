package raisinChallenge.raisinAutomation.Pages;



import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import raisinChallenge.raisinAutomation.Base.Base;


public class EasyAccess extends Base{
	
	@FindBy(xpath="//ng-pluralize[contains(text(),'offers match your search')]")
	WebElement bluebarvalue;
	
	
	//Initializing the Page Object
	public EasyAccess() {
		
		PageFactory.initElements(driver, this);//this is pointing to current class object
	}


	
	//bank name &interest verification method
	public String bankNameEasyAccess(String companyName, String terms) throws Exception {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String interestRate=null;
		WebElement bankname=driver.findElement(By.xpath("//img[contains(@alt,'"+companyName+"')]"));
		System.out.println("The Bank Name is:"+bankname.getAttribute("alt"));
		
		if(bankname.getAttribute("alt").contentEquals(companyName)) {
		  System.out.println("The Code is coming inside the loop condition where bank name is:"+bankname.getAttribute("alt"));
		  
		  List<WebElement> anchors = driver.findElements(By.xpath("//img[contains(@alt,'"+companyName+"')]"));
	      Iterator<WebElement> i = anchors.iterator();

	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      System.out.println("No of entries for this Bank:"+anchors.size());
	      while(i.hasNext()) {
	          WebElement anchor = i.next();
	          String label=anchor.getAttribute("analytics-label");
	          System.out.println("Value of each webelement of entries for this Bank:"+label);
	          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	          WebElement termxpath=anchor.findElement(By.xpath("//img[contains(@analytics-label,'"+label+"')]/parent::div/preceding-sibling::div[@class='prot-offer-header-cell prot-offer-header-term']/div[1]"));
	          System.out.println("Value of terms would be:"+termxpath.getText());

	          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	          termxpath.click();
	          
	          String termxpathvalue=termxpath.getText();
	          if(terms.equals(termxpathvalue)) {
	        	  termxpath.click();
	        	  System.out.println("Value of terms inside loop would be:"+termxpath.getText());

	        	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        	  System.out.println("Code coming inside for loop");
	        	  WebElement interestxpath=termxpath.findElement(By.xpath("//img[contains(@analytics-label,'"+label+"')]/parent::div/preceding-sibling::div/div/div[1]"));
	    	      System.out.println("Value of interest would be"+interestxpath.getText());
	    	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	      interestxpath.click();
	        	  interestRate=interestxpath.getText();
	        	  WebElement registernowbtn=interestxpath.findElement(By.xpath("//img[contains(@analytics-label,'"+label+"')]/parent::div/following-sibling::div[@class='prot-offer-header-cell prot-offer-header-cta']"));
	        	  System.out.println("Value of register now button would be"+registernowbtn.getText());
	        	  registernowbtn.click();
	        	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	        	  break;
	          }
	
	      
	}
		
	}
		return interestRate;
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}

}
