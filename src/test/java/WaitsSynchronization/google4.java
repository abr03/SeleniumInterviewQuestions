package WaitsSynchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;  

public class google4 {

    public static void main(String[] args) throws InterruptedException {

      
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--disable-popup-blocking");
    	options.addArguments("--disable-notifications");

    	WebDriver driver = new ChromeDriver(options);
    	driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Launch Google
        driver.get("https://www.google.co.in/");
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
     List<WebElement>values=   driver.findElements(By.xpath("//button[text()='Stay signed out']"));
     System.out.println("size:"+values.size());
     

        if (driver.findElements(By.xpath("//button[text()='Stay signed out']")).size() > 0) {
            WebElement staySignedOutButton = driver.findElement(By.xpath("//button[text()='Stay signed out']"));
            staySignedOutButton.click();
            System.out.println("Dismissed the alert by clicking 'Stay signed out'.");
        } else {
            System.out.println("No alert to dismiss.");
        }

    }
}
