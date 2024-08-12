package com.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CuraTestCases {
    public static void main(String[] args) {
        // Set up the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();
            // Add a delay to observe the browser actions
            Thread.sleep(2000);

            // Navigate to the Katalon Demo Site
            driver.get("https://katalon-demo-cura.herokuapp.com/");
            // Add a delay to observe the page load
            Thread.sleep(3000);

            // Click on "Make Appointment"
            WebElement makeAppointmentBtn = driver.findElement(By.id("btn-make-appointment"));
            makeAppointmentBtn.click();
            // Add a delay to observe the page transition
            Thread.sleep(3000);

            // Perform login
            WebElement username = driver.findElement(By.id("txt-username"));
            WebElement password = driver.findElement(By.id("txt-password"));
            WebElement loginBtn = driver.findElement(By.id("btn-login"));
            username.sendKeys("John Doe");
            password.sendKeys("ThisIsNotAPassword");
            // Add a delay before clicking login
            Thread.sleep(2000);
            loginBtn.click();
            // Add a delay to observe the login process
            Thread.sleep(3000);

            // Select Facility
            WebElement facility = driver.findElement(By.id("combo_facility"));
            facility.sendKeys("Hongkong CURA Healthcare Center");
            // Add a delay to observe the selection
            Thread.sleep(2000);

            // Check the "Apply for hospital readmission" checkbox
            WebElement hospitalReadmission = driver.findElement(By.id("chk_hospotal_readmission"));
            hospitalReadmission.click();
            // Add a delay to observe the checkbox interaction
            Thread.sleep(2000);

            // Select healthcare program
            WebElement healthcareProgram = driver.findElement(By.id("radio_program_medicaid"));
            healthcareProgram.click();
            // Add a delay to observe the radio button selection
            Thread.sleep(2000);

            // Set visit date
            WebElement visitDate = driver.findElement(By.id("txt_visit_date"));
            visitDate.sendKeys("10/08/2024");
            // Add a delay to observe the date input
            Thread.sleep(2000);

            // Add comment
            WebElement comment = driver.findElement(By.id("txt_comment"));
            comment.sendKeys("Testing appointment booking");
            // Add a delay to observe the comment input
            Thread.sleep(2000);

            // Book appointment
            WebElement bookAppointmentBtn = driver.findElement(By.id("btn-book-appointment"));
            bookAppointmentBtn.click();
            // Add a delay to observe the booking process
            Thread.sleep(3000);

            // Verify if the appointment was booked successfully
            WebElement confirmationMessage = driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]"));
            if (confirmationMessage.isDisplayed()) {
                System.out.println("Test Passed: Appointment was booked successfully.");
            } else {
                System.out.println("Test Failed: Appointment was not booked.");
            }

            // Add a delay to observe the confirmation message
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
