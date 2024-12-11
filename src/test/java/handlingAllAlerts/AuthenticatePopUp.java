package handlingAllAlerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticatePopUp {

	
	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		
		//Will fail because We need to pass Authentication
		//driver.get("https://the-internet.herokuapp.com/digest_auth");
		
		// Below is the code which will workfine, need to passuse username:password@url
		
		driver.get("https://admin:admi@the-internet.herokuapp.com/digest_auth");
		
		
		
	}
}
