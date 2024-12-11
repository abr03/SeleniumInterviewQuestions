package AutocompleteGoogleAPI;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutocompleteGoogle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2); // Disable notifications
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);

		driver.get("https://twoplugs.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[contains(text(),'Live')]")).click();
		//opt.addArguments("--disable-notifications");
Thread.sleep(3000);
	WebElement search=	driver.findElement(By.xpath("//input[@id=\"autocomplete\"]"));

	search.sendKeys("Toronto");
	
	String text=null;
	do {
	search.sendKeys(Keys.ARROW_DOWN);

	text=search.getDomProperty("value");
	//jtext1=search.getDomProperty("value");

	System.out.println("value is :"+text);


	if(text.equals("Toronto NSW, Australia")) {
		
		search.sendKeys(Keys.ENTER);
        options.setExperimentalOption("prefs", prefs);

		break;
	}
		
		
	}while(!text.isEmpty());


		
		
	}

}
