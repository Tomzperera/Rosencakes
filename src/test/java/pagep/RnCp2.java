package pagep;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RnCp2 {
	WebDriver driver;
	
	@FindBy(id="freesrc")
	WebElement search;
	@FindBy(xpath="/html/body/main/div/div/div[1]/div[1]/img")
	WebElement TakeSS;
	@FindBy(xpath="/html/body/main/div/div/div[1]/div/div[1]/a/img")
	WebElement picture;
	@FindBy(xpath="//*[@id=\"cakentype2\"]")
	WebElement btn;
	@FindBy(xpath="//*[@id=\"selcakesize\"]")
	WebElement cakesize;
	@FindBy(id="ordqty")
	WebElement sum;
	@FindBy(xpath="//*[@id=\"deltime\"]")
	WebElement time;
	@FindBy(id="msgoncake")
	WebElement msg;
	@FindBy(name="btnOrder")
	WebElement cart;
	
	public RnCp2(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterinput() {
		search.sendKeys("strawberry cake", Keys.ENTER);
		picture.click();
	}
	public void Capture() throws IOException {
		File src=TakeSS.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./RncFolder/Page.png"));
	}
	public void checkbox() {
		Boolean logo1=driver.findElement(By.xpath("//*[@id=\"availableopt1\"]")).isEnabled();
		if(logo1) {
			System.out.println("Logo is selected");
		}else {
			System.out.println("Logo is not selected");
		}
	}
	public void button() {
		btn.click();
	}
	public void size() {
		Select quantity = new Select(cakesize);
		quantity.selectByVisibleText("1 KG");
		Select aggregate = new Select(sum);
		aggregate.selectByValue("6");
		//Thread.sleep(5000);
	}
	
	public void selectdate() {
		driver.findElement(By.xpath("//*[@id=\"calendar_datePicker\"]")).click();
		while(true) {
		WebElement monthyear=driver.findElement(By.xpath("//*[@id=\"currM\"]"));
		String monthtext=monthyear.getText();
		System.out.println(monthtext);
		
		if(monthtext.equalsIgnoreCase("September 2024")) {
			break;
		}else {
			driver.findElement(By.xpath("//*[@id=\"next\"]")).click();
		}
		}
		
		List<WebElement> lis=driver.findElements(By.xpath("//*[@id=\"frmchk\"]/table[3]/tbody/tr[2]/td[3]/div/table/tbody/tr/td/span"));
		for(WebElement ele:lis) {
			String day=ele.getText();
			if(day.equals("24")) {
				ele.click();
			}
		}
		}
	
	public void deliverytime() {
		Select dlvry=new Select(time);
		dlvry.selectByValue("6:00 PM to 9:00 PM");
	}
	
	public void message() {
		msg.sendKeys("Happy Birthday Dear");
	}
	
	public void Addtocart() {
		cart.click();
	}

}
