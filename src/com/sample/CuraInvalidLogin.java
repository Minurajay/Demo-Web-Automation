package com.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CuraInvalidLogin {
    public static void main(String[] args) {
        // Set up the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();
            Thread.sleep(2000);

            // Navigate to the Katalon Demo Site
            driver.get("https://katalon-demo-cura.herokuapp.com/");
            Thread.sleep(3000);

            // Click on "Make Appointment"
            WebElement makeAppointmentBtn = driver.findElement(By.id("btn-make-appointment"));
            makeAppointmentBtn.click();
            Thread.sleep(3000);

            // Perform login with invalid credentials
            WebElement username = driver.findElement(By.id("txt-username"));
            WebElement password = driver.findElement(By.id("txt-password"));
            WebElement loginBtn = driver.findElement(By.id("btn-login"));
            username.sendKeys("InvalidUser");
            password.sendKeys("InvalidPassword");
            Thread.sleep(2000);
            loginBtn.click();
            Thread.sleep(3000);

            // Verify if the error message is displayed
            WebElement errorMessage = driver.findElement(By.xpath("//p[@class='lead text-danger']"));
            if (errorMessage.isDisplayed()) {
                System.out.println("Test Passed: Error message displayed for invalid login.");
            } else {
                System.out.println("Test Failed: Error message not displayed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
