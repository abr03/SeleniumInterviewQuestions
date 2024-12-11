package LocateLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.http.HttpRequest;

public class BrokenLinks {
	
	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		//String url="http://www.deadlinkcity.com/";
		driver.get("http://www.deadlinkcity.com/");
		
		driver.manage().window().maximize();
		
		List<WebElement>AllLinks=driver.findElements(By.xpath("//a"));
		
		System.out.println("Size is :"+AllLinks.size());

	//	URL url= new URL("http://www.deadlinkcity.com/");
		
	
		for(WebElement links: AllLinks) {
			
			String url=links.getDomAttribute("href");
			
			if(url!=null && !url.isEmpty()) {
				
				try {
					URL linkUrl=new URL(url);
				HttpURLConnection huc=	(HttpURLConnection) linkUrl.openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();
			int responsecode=	huc.getResponseCode();
			
			if(responsecode>=400) {
				System.out.println(url +": is broken link.");
				
			}else {
                System.out.println(url + " is a valid link.");

			}
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			//HttpRequest hr= new HttpRequest
		}
		
		
	}

}
