package getCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/*
 * launch Browser in WebDriver
 * Open URL
 * cAPTURE Title
 * Capture URL of the page
 * Capture Pagesource of the page
 *
 * 
 */
public class BrowserGetCommands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		System.out.println("Titile is :"+driver.getTitle());
		//Url of the page
		
		System.out.println("Url is:"+driver.getCurrentUrl());
		
		System.out.println("pagesourse is :"+driver.getPageSource());
		
		driver.close();

	}

}
