package bootstrapDropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDowns {

    public static void main(String[] args) {
        // Launch browser and select the product type
        selectProductDtype();
    }

    public static void selectProductDtype() {
        ChromeOptions opt= new ChromeOptions();
        opt.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(opt);

        driver.get("https://www.hdfcbank.com");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
        try {
            Alert alt=driver.switchTo().alert();
            alt.dismiss();
            WebElement cookieOkButton = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
            cookieOkButton.click();
            System.out.println("Cookie banner dismissed.");

        }catch (Exception e) {
        	
        	System.out.println("Unable to find alert!");
			// TODO: handle exception
		}
       
     }
    
}
