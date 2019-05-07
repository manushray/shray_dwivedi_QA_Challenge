package raisinChallenge.raisinAutomation.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import raisinChallenge.raisinAutomation.Utility.UtilUsage;


public class Base 
{
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log= LogManager.getLogger(Base.class);
	
	
	//Constructor using for reading the config properties file
	public Base(){
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		try {
			prop =new Properties();
			String dir_path =System.getProperty("user.dir");
			FileInputStream ip= new FileInputStream(dir_path+"/src/main/java/raisinChallenge/raisinAutomation/Configuration/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//Method used to initialise the Browser and launching the URL 
	public static void initialisation() throws Exception {
		
		
		String browserName=  prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			ChromeOptions coptions = new ChromeOptions();
			coptions.addArguments("--disable-notifications");
			driver = new ChromeDriver(coptions);
		}else if(browserName.equals("Firefox")) {
			driver= new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(UtilUsage.implicit_wait, TimeUnit.SECONDS);
		log.info("Class Base > initialisation method has been invoked ");
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(UtilUsage.implicit_wait, TimeUnit.SECONDS);

		WebElement closebtnParenttag=driver.findElement(By.xpath("//div[contains(@class,'modal-dialog modal-md\')]"));

		WebElement closebtn=closebtnParenttag.findElement(By.className("close"));
		closebtn.click();
		driver.manage().timeouts().pageLoadTimeout(UtilUsage.implicit_wait, TimeUnit.SECONDS);
		

		
	}
	
	public static void waitForElement(WebDriver driver, WebElement element) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
}
