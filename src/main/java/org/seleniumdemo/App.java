package org.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class App {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.python.org");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("pycon");
        searchBox.submit();
        System.out.println("Title: " + driver.getTitle());
        driver.quit();
    }
}
