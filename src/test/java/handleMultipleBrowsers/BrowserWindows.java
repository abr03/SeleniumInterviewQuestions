package handleMultipleBrowsers;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//firstmethod(driver);
		SecondMethod(driver);
		
		

	}
	/*
	 * 1st methoid using iterator
	 */
	public static void firstmethod(WebDriver driver) {
		System.out.println(driver.getTitle());
		String parentWindow=driver.getWindowHandle();
		System.out.println("parent window:"+parentWindow);
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		Set<String>windows=driver.getWindowHandles();
		
		

		Iterator<String>Allwindows=windows.iterator();
		
		System.out.println("size is :"+windows.size());
		while(Allwindows.hasNext()) {
			
		String child=	Allwindows.next();
		
		if(!child.equals(parentWindow)) {
			
			driver.switchTo().window(child);
			System.out.println("Child window: "+child);
			System.out.println(driver.getTitle());
			
		}
		

		}
		
		
	}
	
	public static void SecondMethod(WebDriver driver) {
		
		System.out.println(driver.getTitle());
		String parentWindow=driver.getWindowHandle();
		System.out.println("parent window:"+parentWindow);
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		Set<String>windows=driver.getWindowHandles();
		Iterator<String>Allwindows=windows.iterator();
		
		for(String wind: windows) {
			
		String ChildWindow=	Allwindows.next();
		if(!ChildWindow.equals(parentWindow)) {
			driver.switchTo().window(ChildWindow);
			System.out.println("Child window: "+ChildWindow);
			System.out.println(driver.getTitle());

		}
			
		}

		
	}


}
