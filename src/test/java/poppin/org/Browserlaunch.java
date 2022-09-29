package poppin.org;


import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class Browserlaunch extends Baseclass {

public static void main(String[] args) throws InterruptedException, IOException {
		
		launchChrome();
		winMax();
		loadUrl("https://www.poppin.com");
		printTitle();
		printCurrentUrl();
		
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
		
		
		//driver.findElement(By.xpath("//input[@class='form-control input-text email-input required parsley-validated']")).sendKeys("greens");

		Loginpojo p = new Loginpojo();
		WebElement txtUser = p.getTxtUser();
		fill(txtUser, getData(1, 0, "Sheet1", "C:\\Users\\user\\eclipse-workspace\\Clone Maven Configuration\\GITAug-17\\Excel\\poppin.xlsx"));
		
		//txtUser.sendKeys("greens");
		
		WebElement txtPass = p.getTxtPass();
		fill(txtPass, getData(1, 1, "Sheet1", "C:\\Users\\user\\eclipse-workspace\\Clone Maven Configuration\\GITAug-17\\Excel\\poppin.xlsx"));
		
		WebElement btnLogin = p.getBtnLogin();
		btnClick(btnLogin);

		/*Thread.sleep(1000);
		WebElement register = driver.findElement(By.xpath("//a[@title='Register'][1]"));
		a.moveToElement(register).perform();
		register.click();
		
		WebElement fname =driver.findElement(By.id("dwfrm_profile_customer_firstname"));
		fill(fname,"Rathiga");
		
		
		WebElement lname =driver.findElement(By.id("dwfrm_profile_customer_lastname"));
		fill(lname,"tharan");
	*/
		
	}
}
