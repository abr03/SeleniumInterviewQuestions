package ElementDispSelectEnabled;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementStatus {
	static WebDriver driver;
	
	
	public static void main(String[] args) {
		
		getBrowser();
		ElementisDisplayed();
		ElementisEnabled();
		ElementSelected();
	
	}
	
	public static Boolean ElementisEnabled() {
		Boolean isEnabled=	driver.findElement(By.xpath("//button[text()='Sign in']")).isEnabled();
		System.out.println("Element is Enabled: "+isEnabled);
		return isEnabled;

	}
	
	
	public static Boolean ElementisDisplayed() {
		Boolean isDisplayed=	driver.findElement(By.xpath("//button[text()='Sign in']")).isDisplayed();
System.out.println("Element is Displayed: "+isDisplayed);
return isDisplayed;
	}
	
	public static  Boolean  ElementSelected() {
	Boolean isSelected=	driver.findElement(By.xpath("//button[text()='Sign in']")).isSelected();
	System.out.println("Element is Selected :"+isSelected);
	return isSelected;
	}
	
	public static WebDriver getBrowser() {
		driver = new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		return driver;
	}

}
