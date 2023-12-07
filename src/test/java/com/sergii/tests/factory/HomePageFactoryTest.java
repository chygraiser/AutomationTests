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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        log.info("Web site is opened");
    }

    @Test
    @DisplayName(value = "Text name test")
    public void textTest(){

        log.info("Text name test is started");

        String text = homePageFactory.getText();

        homePageFactory.getText();
        Assertions.assertThat(text).isEqualTo("Deliver to");

    }

    @Test
    @DisplayName(value = "Country click test")
    public void countryClickTest(){

        log.info("Country click test is started");

        homePageFactory.clickCountry();

        String countryName = driver.findElement(By.xpath("//*[@id='a-popover-header-1']")).getText();
        Assertions.assertThat(countryName).isEqualTo("Choose your location");

    }

    @Test
    @DisplayName(value = "Account click test")
    public void accountClickTest(){

        log.info("Account click test is started");

        homePageFactory.clickAccount();

        String accountClick = driver.findElement(By.xpath("//h1[@class='a-spacing-small']")).getText();
        Assertions.assertThat(accountClick).isEqualTo("Sign in");

    }


    @AfterEach
    public void afterHook(){
        driver.quit();
        log.info("Web site is closed");
    }

}
