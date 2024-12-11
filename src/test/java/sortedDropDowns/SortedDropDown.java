package sortedDropDowns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SortedDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://twoplugs.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		System.out.println(driver.getTitle());
		sortElements(driver);
		

	}
	
	public static void sortElements(WebDriver driver) {
	WebElement optionsname=driver.findElement(By.xpath("//select[@name='category_id']"));
	
	Select select= new Select(optionsname);
	List<WebElement>Alloptions=select.getOptions();
	ArrayList<String>Original= new  ArrayList<String>();
	ArrayList<String>Temperory= new  ArrayList<String>();
	
	for(WebElement ele: Alloptions) {
		String serviceOptions=ele.getText();
		Original.add(serviceOptions);
		Temperory.add(serviceOptions);

	}
	System.out.println("Orginal List:"+Original.size());
	System.out.println("Temp List:"+Temperory.size());
	
	System.out.println("Orginal List:"+Original);
	System.out.println("Temp List:"+Temperory);

//	Collections.sort(Temperory);
	HashSet<String> hs= new HashSet<String>(Temperory);
	hs.addAll(Temperory);
	
	System.out.println("Temp List:"+Temperory.size());
	System.out.println("Temp List:"+Temperory);

	if(Original.equals(Temperory)) {
		System.out.println("Sorted List is Original");
	}
	else {
		System.out.println("Sorted List is Temperory");

	}

	
	//Original.addAll(Alloptions);

		
	}

}
