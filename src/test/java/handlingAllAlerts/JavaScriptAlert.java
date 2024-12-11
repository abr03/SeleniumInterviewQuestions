package handlingAllAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAlert {

	
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver(); driver.get("https://www.browserstack.com/users/sign_up");
	
	
		driver.findElement(By.id("user_full_name")).sendKeys("harsha.kumar-n@alstomgroup.com"); 
		driver.findElement(By.id("input-lg text user_email_ajax")).sendKeys("Harsha@07");
	
		
		driver.findElement(By.id("user_submit")).click();
		
		
		Alert alt=	driver.switchTo().alert();
		
		alt.accept();
		
		String text=alt.getText();
		
		alt.sendKeys(text);
		
		
		
	}
}
