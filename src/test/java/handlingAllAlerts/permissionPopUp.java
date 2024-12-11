package handlingAllAlerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class permissionPopUp {
	
	public static void main(String[] args) {
		
		
		ChromeOptions options= new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://www.hdfcbank.com/");
		
		/*
		 * driver.get("http://wordpressdemo.webkul.com/wordpress-latest-tweets/");
		 */
		
	}

}
