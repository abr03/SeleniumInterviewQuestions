package LocateLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindNoOfBrokenLinks {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://www.deadlinkcity.com/");

            // Find all <a> elements on the page
            List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
            int brokenLinkCount = 0;

            // Loop through each link
            for (WebElement link : totalLinks) {
                String url = link.getDomAttribute("href"); // Use getAttribute for 'href'

                // Check if the URL is null or empty
                if (url == null || url.isEmpty()) {
                    System.out.println("URL is empty or null for link: " + link.getText());
                    continue;
                }

                try {
                    // Open the connection and check the response code
                    HttpURLConnection huc = (HttpURLConnection) new URL(url).openConnection();
                  //  huc.setConnectTimeout(5000); // Timeout to avoid long waits
                  //  huc.setRequestMethod("HEAD"); // Use HEAD request to check the link
                    huc.connect();

                    int responseCode = huc.getResponseCode();

                    if (responseCode >= 400) { // Broken link
                        System.out.println(url + " is a broken link with response code: " + responseCode);
                        brokenLinkCount++;
                    } else { // Valid link
                        System.out.println(url + " is a valid link with response code: " + responseCode);
                    }
                } catch (Exception e) {
                    System.out.println("Error checking link: " + url + " - " + e.getMessage());
                    brokenLinkCount++;
                }
            }

            System.out.println("Total number of broken links: " + brokenLinkCount);

        } finally {
            driver.quit(); // Ensure the browser is closed even if an exception occurs
        }
    }
}
