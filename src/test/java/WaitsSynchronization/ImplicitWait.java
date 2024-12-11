package WaitsSynchronization;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String baseUrl = "http://www.google.com";
        driver.get(baseUrl);

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Locate Google's search box
            WebElement element = driver.findElement(By.name("q"));
            element.sendKeys("Selenium WebDriver Interview questions");
            element.sendKeys(Keys.RETURN);

            // Locate search result links
            List<WebElement> list = driver.findElements(By.className("iUh30"));
            System.out.println("Number of links found: " + list.size());

        } catch (NoSuchElementException e) {
            System.out.println("Could not locate element: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

        // Handle "Stay signed out" button if it appears
        try {
            if (driver.findElements(By.xpath("//button[text()='Stay signed out']")).size() > 0) {
                WebElement signOut = driver.findElement(By.xpath("//button[text()='Stay signed out']"));
                signOut.click();
                System.out.println("Clicked on 'Stay signed out' button.");
            } else {
                System.out.println("'Stay signed out' button is not present.");
            }
        } catch (Exception e) {
            System.out.println("Error while handling 'Stay signed out' button: " + e.getMessage());
        }

        // Close the browser
        driver.quit();
    }
}
