package basep;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
protected WebDriver driver;
String s="https://www.rosencakes.com/";
	
	@BeforeTest
	public void Setup() {
		driver = new ChromeDriver();
		driver.get(s);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe(s));
		
	}
	@AfterTest
	public void postCondition() {
		driver.quit();

}

}
