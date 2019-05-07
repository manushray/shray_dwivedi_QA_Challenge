package raisinChallenge.raisinAutomation.Utility;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import raisinChallenge.raisinAutomation.Base.Base;

public class UtilUsage extends Base {

	public static long PAGE_LOAD_TIMEOUT = 100;
	public static long implicit_wait= 100;
	
	
	public String extracterMethod(String extractElementName) throws InterruptedException {
		List<WebElement> anchors = driver.findElements(By.className(prop.getProperty("bank_moody_rating_className")));
	      Iterator<WebElement> i = anchors.iterator();
	      Thread.sleep(1200);
	      while(i.hasNext()) {
	          WebElement anchor = i.next();
	          System.out.println("Moody Rating Text is:"+anchor.getText());
	          if(anchor.getText().contains(extractElementName)) {
	        	  System.out.println("Moody Rating Location is:"+anchor.getLocation());
	              anchor.click();
	              break;
	          }
		 
		  Thread.sleep(500);
	  }
		return null;

	}
}
