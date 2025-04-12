package org.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class App {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions opts = new ChromeOptions();


        String url = "https://www.google.com";
        String keyword = "Gmail";
        WebDriver driver = new ChromeDriver(opts);

        try{
            System.out.println("Opening " + url );
            driver.get(url);
            String bodytxt = driver.findElement(By.tagName("body")).getText();
            if(bodytxt.toLowerCase().contains(keyword.toLowerCase()) ){
                System.out.println("Keyword Found");
            }
            else{
                System.out.println("keyword not found");
            }
        }
        catch (Exception e){
            System.out.println("Error Occured " + e.getMessage());
        }
        finally{
            try {
                Thread.sleep(5000); // Wait 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
        
    }
}
