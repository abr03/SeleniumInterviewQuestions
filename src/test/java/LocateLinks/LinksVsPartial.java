package LocateLinks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksVsPartial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		// Link Text
		WebElement ele=	driver.findElement(By.linkText("Errorcode 400"));
		
		System.out.println(ele);
		
		// Partial Link
		WebElement PartialEle=	driver.findElement(By.partialLinkText("401"));
		System.out.println(PartialEle);

		//Print all Links
		
		List<WebElement>AllLinks=driver.findElements(By.xpath("//a"));
		System.out.println("No of Links :"+AllLinks.size());
		for(WebElement links: AllLinks) {
			
		String Linkname=	links.getText();
		System.out.println("name of link:"+ Linkname);
		
		String AttributeName=links.getDomAttribute("href");
		System.out.println("name of Attribute :"+AttributeName);
		
		
		
		}
		

	}

}
