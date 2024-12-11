package WaitsSynchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;  

public class google {

    public static void main(String[] args) throws InterruptedException {

    	
    	ChromeOptions options = new ChromeOptions();
    	options.setExperimentalOption("excludeSwitches", new String[]{"enable Automation"});
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Launch Google
        driver.get("https://www.google.co.in/");

        // Check for "Stay signed out" button
        List<WebElement> signOutButtons = driver.findElements(By.xpath("//button[text()='Stay signed out']"));
Thread.sleep(2000);
        if (!signOutButtons.isEmpty()) {
            // Element is present, interact with it
        	// System.out.println( signOutButtons.get(0).getText());
        	WebElement signOutButton = driver.findElement(By.xpath("//button[text()='Stay signed out']"));
        	signOutButton.click();
           // signOutButtons.get(0).click();
            System.out.println("Clicked on 'Stay signed out' button.");
        } else {
            // Element is not present
            System.out.println("'Stay signed out' button is not present.");
        }

        // Proceed with your test script
        System.out.println("Continuing with the test...");

        // Close the browser
      //  driver.quit();
    }
}
