package poppin.org;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Loginpojo extends Baseclass{

	public Loginpojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@class='form-control input-text email-input required parsley-validated']")
	private WebElement txtUser;

	@FindBy(xpath="//input[@class='form-control input-text-pw password-input required parsley-validated']")
	private WebElement txtPass;

	@FindBy(xpath="(//button[@class='btn btn-default btn-block'])[1]")
	private WebElement btnLogin;

	public WebElement getTxtUser() {
	return txtUser;
}

	public WebElement getTxtPass() {
	return txtPass;
}

	public WebElement getBtnLogin() {
	return btnLogin;
}


}
