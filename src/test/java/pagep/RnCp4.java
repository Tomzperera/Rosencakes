package pagep;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RnCp4 {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"footer\"]/div[2]/div/div[1]/ul/li[1]/a")
	WebElement firsticon;
	
	public RnCp4(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Facebook() throws InterruptedException {
		String parentwindow=driver.getWindowHandle();//current window
    	System.out.println("Parent Window Title: "+driver.getTitle());
		firsticon.click();
		
		Set<String> allwindow=driver.getWindowHandles();
    	for(String handle: allwindow) {
    		if(!handle.equalsIgnoreCase(parentwindow)) {
    			driver.switchTo().window(handle);
    			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div/div[5]/div/div/div[1]/div/div[2]/div/div/div/div[1]/div")));
                element.click();
                Thread.sleep(5000);
                driver.close();
    		}
    		Thread.sleep(5000);
    		driver.switchTo().window(parentwindow);
    	}
	}

	
}
