package pagep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RnCp1 {
	WebDriver driver;
	@FindBy(xpath = "/html/body/header/div[1]/div/div[2]/p/a[3]")
	WebElement sign_in;
	@FindBy(id="usemail")
	WebElement mailid;
	@FindBy(id="usrpass")
	WebElement pswd;
	@FindBy(xpath="//*[@id=\"btwnreg\"]")
	WebElement tap;
	
	public RnCp1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login() {
		sign_in.click();
	}
	public void passvalues(String UN, String PSD) {
		mailid.clear();
		mailid.sendKeys(UN);
		
		pswd.clear();
		pswd.sendKeys(PSD);
	}
	public void pressbtn() {
		tap.click();
	}

}
