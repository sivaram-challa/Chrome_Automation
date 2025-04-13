package org.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        String url = "https://in.linkedin.com";
        int delay = 5000;

        try {
            System.out.println("Opening " + url);
            driver.get(url);

            Thread.sleep(3000);

            List<WebElement> signInElements = driver.findElements(By.xpath(
                "//a[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'sign in')]" +
                "| //button[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'sign in')]"
            ));

            if (!signInElements.isEmpty()) {
                System.out.println("✅ 'Sign in' element found. Clicking...");
                signInElements.get(0).click();
            } else {
                List<WebElement> profileElements = driver.findElements(By.xpath(
                    "//a[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'profile')]" +
                    "| //button[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'profile')]"
                ));

                if (!profileElements.isEmpty()) {
                    System.out.println("ℹ️ 'Sign in' not found. Clicking on 'Profile'...");
                    profileElements.get(0).click();
                } else {
                    System.out.println("❌ Neither 'Sign in' nor 'Profile' found.");
                }
            }

            Thread.sleep(delay);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("✅ Browser closed.");
        }
    }
}
