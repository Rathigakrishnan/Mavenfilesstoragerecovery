package poppin.org;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Addtocart extends Baseclass{

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
		
		
		
		WebElement Email = driver.findElement(By.xpath("//input[@class='form-control input-text email-input required parsley-validated']"));
		Email.sendKeys("tharanrathiga@gmail.com");
		WebElement pass = driver.findElement(By.xpath("//input[@class='form-control input-text-pw password-input required parsley-validated']"));
		pass.sendKeys("Poppinproject1");
		WebElement login = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		login.click();
		
		WebElement furniture = driver.findElement(By.xpath("//span[text()='Furniture']"));
		a.moveToElement(furniture).perform();
		
		WebElement heightdesk = driver.findElement(By.xpath("//span[text()='Adjustable Height Desks']"));
		a.moveToElement(heightdesk).perform();
		heightdesk.click();
		
		WebElement Adjwhitedesk = driver.findElement(By.xpath("//div[@class='product-name product-name1075061']"));
		Adjwhitedesk.click();
		
		WebElement add2cart = driver.findElement(By.id("add-to-cart"));
		add2cart.click();
		
		
}
}
