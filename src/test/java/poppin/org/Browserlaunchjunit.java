package poppin.org;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Browserlaunchjunit extends Baseclass{

	@BeforeClass
	public static void browserLaunch()  {
		launchChrome();
		winMax();
		
		
}
	
	@AfterClass
	public static void browserClose() {
		closeBrowser();
	} 
	
	@Before
	public void startTime() throws InterruptedException {
		loadUrl("https://www.poppin.com");
		Date d = new Date();
		System.out.println(d);
		
		Thread.sleep(1000);
		WebElement close = driver.findElement(By.xpath("//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button onetrust-lg ot-close-icon']"));
		close.click();
		
		Thread.sleep(1000);
		WebElement no = driver.findElement(By.xpath("//input[@class='ltkmodal-subscribe-two ltkmodal-close']"));
		Thread.sleep(1000);
		no.click();
		
		WebElement signin = driver.findElement(By.xpath("//i[@class='icon-pop-utility-myaccount'][1]"));
		Actions a=new Actions(driver);
		a.moveToElement(signin).perform();
		signin.click();
	}
	
	@After
	public void endTime() {
		Date d = new Date();
		System.out.println(d);
}
	
	
	
	//valid user name invalid password
	@Test
	public void tc1() throws IOException, InterruptedException {
		Loginpojo l = new Loginpojo();
		fill(l.getTxtUser(), getData(3, 0, "Sheet1", "C:\\Users\\user\\eclipse-workspace\\Clone Maven Configuration\\GITAug-17\\Excel\\poppin.xlsx"));
		fill(l.getTxtPass(), getData(3, 1, "Sheet1", "C:\\Users\\user\\eclipse-workspace\\Clone Maven Configuration\\GITAug-17\\Excel\\poppin.xlsx"));
		btnClick(l.getBtnLogin());
		System.out.println("Login Failed");
		Thread.sleep(2000);
	}
	//invalid user name and valid password
	@Ignore
	@Test
	public void tc2() throws IOException, InterruptedException {
		Assert.assertTrue(false);;
		Loginpojo l = new Loginpojo();
		fill(l.getTxtUser(), getData(2, 0, "Sheet1", "C:\\Users\\user\\eclipse-workspace\\Clone Maven Configuration\\GITAug-17\\Excel\\poppin.xlsx"));
		fill(l.getTxtPass(), getData(2, 1, "Sheet1", "C:\\Users\\user\\eclipse-workspace\\Clone Maven Configuration\\GITAug-17\\Excel\\poppin.xlsx"));
		btnClick(l.getBtnLogin());
		System.out.println("Login Failed");
		Thread.sleep(2000);
	}
	//valid user name and valid password
	@Test
	public void tc3() throws IOException, InterruptedException {
		Loginpojo l = new Loginpojo();
		fill(l.getTxtUser(), getData(1, 0, "Sheet1", "C:\\Users\\user\\eclipse-workspace\\Clone Maven Configuration\\GITAug-17\\Excel\\poppin.xlsx"));
		fill(l.getTxtPass(), getData(1, 1, "Sheet1", "C:\\Users\\user\\eclipse-workspace\\Clone Maven Configuration\\GITAug-17\\Excel\\poppin.xlsx"));
		btnClick(l.getBtnLogin());
		System.out.println("Login Sucess");
		Thread.sleep(2000);
	}
}
