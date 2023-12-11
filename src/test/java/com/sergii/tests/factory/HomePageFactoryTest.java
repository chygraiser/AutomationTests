package com.sergii.tests.factory;

import com.sergii.code.factory.HomePageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePageFactoryTest {

    private HomePageFactory homePageFactory;
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(HomePageFactoryTest.class);

    @BeforeEach
    public void beforeHook() {
        driver = new ChromeDriver();
        homePageFactory = new HomePageFactory(driver);
        driver.get("https://www.amazon.com/");
        log.info("Web site is opened");
    }

    @Test
    @DisplayName(value = "Text name test")
    public void textTest(){

        log.info("Text name test is started");
        homePageFactory.getText();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("glow-ingress-line1")));
        Assertions.assertThat(homePageFactory.getText()).isEqualTo("Deliver to");

    }

    @Test
    @DisplayName(value = "Country click test")
    public void countryClickTest(){

        log.info("Country click test is started");
        homePageFactory.clickCountry();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("a-popover-header-1")));
        Assertions.assertThat(homePageFactory.getCountryText()).isEqualTo("Choose your location");

    }

    @Test
    @DisplayName(value = "Account click test")
    public void accountClickTest(){

        log.info("Account click test is started");
        homePageFactory.clickAccount();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("authportal-main-section")));
        Assertions.assertThat(homePageFactory.getAccountFormConfirm()).isEqualTo("Sign in\n" +
                "Email or mobile phone number\n" +
                "Continue\n" +
                "By continuing, you agree to Amazon's Conditions of Use and Privacy Notice.\n" +
                "Need help?\n" +
                "Buying for work?\n" +
                "Shop on Amazon Business\n" +
                "New to Amazon?\n" +
                "Create your Amazon account");

    }

    @AfterEach
    public void afterHook(){
        driver.quit();
        log.info("Web site is closed");
    }

}
