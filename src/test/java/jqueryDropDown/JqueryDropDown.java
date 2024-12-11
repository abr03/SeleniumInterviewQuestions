package jqueryDropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JqueryDropDown {
	
	
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("justAnInputBox")).click();


		SelectDropDown(driver, "All");
		
		//String name[]= {"abc","ceac"};

		
	
	}
	
	public static void SelectDropDown(WebDriver driver,String...value) {
		List<WebElement>choiceList=driver.findElements(By.xpath("//li[@class='ComboTreeItemChlid']//span[contains(text(),'choice')]"));
		
		if(!value[0].equalsIgnoreCase("all")) {
			
			//Compare elements 
			for(WebElement item: choiceList) {
				
				String choice=item.getText();
				/*
				 * System.out.println("No of items are: "+item.getSize());
				 * 
				 * System.out.println("choices are:"+choice);
				 */
				for(String val: value) {
					
					if(choice.equals(val)) {
						
						new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(item));
						item.click();
						break;
					}
					
				}
			}
			
		}
		
		else {
			try {
				for(WebElement ele: choiceList) {
					
					ele.click();
			}
			}
				catch (Exception e) {
					
					System.out.println("Handle Exception:"+e.getMessage());
				}
			
			}
		}
	}


