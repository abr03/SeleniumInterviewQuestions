package handleMultipleBrowsers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindows2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String parentTitlte=driver.getTitle();
		String parentId=driver.getWindowHandle();
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		Set<String>windowId=driver.getWindowHandles();
		/*
		 * Iterator<String>it=windowId.iterator(); String parentId=it.next(); String
		 * ChildId=it.next(); System.out.println(parentId+" parentid");
		 * System.out.println(ChildId+" Child id");
		 * 
		 * List<String>ls= new ArrayList<String>(windowId); String pid= ls.get(0);
		 * String cid=ls.get(1);
		 * 
		 * System.out.println("pid :"+pid); System.out.println("cid :"+cid);
		 * 
		 * driver.switchTo().window(cid);
		 * System.out.println("Titile is :"+driver.getTitle());
		 */
	    
	    
	    
	    for(String win: windowId) {
	    	
	    	if(!win.equals(parentId)) {
	    		driver.switchTo().window(win);
	    		String title=driver.getTitle();
	    		
	    		if(!title.equals(parentTitlte)) {
	    			
	    			driver.close();
	    		}
	    		
	    }
	    }

		/*
		 * Set<String>ss= new LinkedHashSet<String>(windowId);
		 * 
		 * ss.
		 */


	}

}
