package handleAutoSuggestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownAutoSuggestions {
	
	public static void main(String[] args) {
		
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.google.co.in/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//textarea[@aria-label='Search']")).sendKeys("Selenium");
		
		List<WebElement>suggetsions=driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//following::div[@class='pcTkSc']//span[contains(text(),'selenium')]"));
		
		System.out.println("size is:"+suggetsions.size());
		
		for(WebElement ele: suggetsions) {
			
			String Search=ele.getText();
			
			if(Search.contains("foods")) {
				System.out.println("Suggestion is :"+Search);
				ele.click();
				break;
			}
		}
		
	}

}
