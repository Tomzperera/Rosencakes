package pagep;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RnCp3 {
	WebDriver driver;
	@FindBy(name="couponval")
	WebElement code;
	
	@FindBy(xpath="//*[@id=\"frmqtyu\"]/table[3]/tbody/tr[2]/td[2]/input[2]")
	WebElement popups;
	
	@FindBy(xpath="//*[@id=\"frmqtyu\"]/table[5]/tbody/tr/td[2]/table/tbody/tr[1]/td/a/b")
	WebElement gotoorder;
	@FindBy(xpath="//*[@id=\"shcountry\"]")
	WebElement setCountry;
	@FindBy(xpath="/html/body/header/div[2]/div/div/div[3]/div/div/div/a")
	WebElement cartbtn;
	
	@FindBy(xpath="/html/body/header/div[1]/div/div[2]/p/a[4]")
	WebElement Terminate;
	
	public RnCp3(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void coupon() {
		code.sendKeys("fgvft65");
	}
	public void warning() {
		popups.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Popup message: " + alert.getText());
        alert.accept();
	}
	public void order() {
		gotoorder.click();
		driver.findElement(By.xpath("//*[@id=\"regform\"]/input")).click();
	}
	public void receiverdetails() {
		driver.findElement(By.name("recname")).sendKeys("Nevaeh");
		driver.findElement(By.xpath("//*[@id=\"frmbook\"]/table/tbody/tr[11]/td[3]/input")).sendKeys("6282438980");
		driver.findElement(By.name("address1")).sendKeys("Trivandrum");
		driver.findElement(By.xpath("//*[@id=\"frmbook\"]/table/tbody/tr[15]/td[3]/input")).sendKeys("Kazhakoottam");
		driver.findElement(By.xpath("//*[@id=\"frmbook\"]/table/tbody/tr[17]/td[3]/input")).sendKeys("695022");
		driver.findElement(By.xpath("//*[@id=\"frmbook\"]/table/tbody/tr[19]/td[3]/input")).sendKeys("Kerala");
	}
	public void Country() {
		Select ss = new Select(setCountry);
		ss.selectByVisibleText("India");
	}
	
	public void cart() {
		cartbtn.click();
		driver.findElement(By.xpath("//*[@id=\"frmqtyu\"]/table[1]/tbody/tr[2]/td[6]/a/strong")).click();
	}
	
	public void Logout() {
		Terminate.click();
	}

}
