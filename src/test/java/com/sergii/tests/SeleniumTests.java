package com.sergii.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests {

    private static final Logger log = LogManager.getLogger(SeleniumTests.class);
    WebDriver driver = new ChromeDriver();


   @BeforeEach
    public void openWebSite() {
        driver.get("https://the-internet.herokuapp.com/login");
        log.info("Web site is opened");
    }

    @Test
    @DisplayName(value = "Valid data Login")
    public void positiveTest(){


        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        log.info("Login form is filled by valid data");

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        log.info("Login form is submitted with valid data");


        String successMessage = driver.findElement(By.cssSelector(".flash.success")).getText();
        Assertions.assertEquals("You logged into a secure area!\n×", successMessage.trim(), "Wrong Login message");
        log.info("Login with valid data is passed");

    }

    @Test
    @DisplayName(value = "Invalid user name Login")
    public void negativeTestUserName(){


        driver.findElement(By.id("username")).sendKeys("invalidUser");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        log.info("Login form is filled with invalid user name");

        String errorMessage = driver.findElement(By.cssSelector(".flash.error")).getText();
        Assertions.assertEquals("Your username is invalid!\n×", errorMessage.trim(), "Wrong Login message");
        log.info("Login with invalid user name is passed");

    }

    @Test
    @DisplayName(value = "Invalid password Login")
    public void negativeTestPassword(){

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("invalidPassword");
        log.info("Login form is filled with invalid password");

        String errorMessage2 = driver.findElement(By.cssSelector(".flash.error")).getText();
        Assertions.assertEquals("Your password is invalid!\n×", errorMessage2.trim(), "Wrong error message");
        log.info("Login with invalid password is passed");

    }

    @AfterEach
    public void closeWebDriver() {
        if (driver != null) {
            driver.quit();
            log.info("Web site is closed");
        }
    }


}
