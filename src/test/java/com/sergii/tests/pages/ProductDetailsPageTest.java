package com.sergii.tests.pages;

import com.sergii.code.pages.ProductDetailsPage;
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

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProductDetailsPageTest {

    private static final Logger log = LogManager.getLogger(ProductDetailsPageTest.class);
    private WebDriver driver;

    private ProductDetailsPage productDetailsPage;

    @BeforeEach
    public void beforeHook() {

        driver = new ChromeDriver();
        productDetailsPage = new ProductDetailsPage(driver);
        driver.get("https://www.amazon.com/TMKB-Keyboard-Ultra-Compact-Mechanical-T68SE/dp/B0BHSSZ8NJ/ref=sr_1_1_sspa");
        log.info("Web site is opened");
    }

    @Test
    @DisplayName(value = "PDP name test")
    public void pdpNameTest(){

        log.info("PDP name test is started");

        String text = productDetailsPage.getPdpText();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        productDetailsPage.getPdpText();

        Assertions.assertThat(text).isEqualTo("TMKB 60 Percent Keyboard,Gaming Keyboard 60 Percent, LED Backlit Ultra-Compact 68 Keys Gaming Mechanical Keyboard with Separate Arrow/Control Keys, T68SE, Brown Switch");


        log.info("PDP name test is finished");

    }

    @Test
    @DisplayName(value = "Add to cart click test")
    public void clickAddToCart(){

        log.info("Add to cart click test is started");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        productDetailsPage.clickAddToCart();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String successMessage = driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")).getText();
        Assertions.assertThat(successMessage).isEqualTo("Added to Cart");

        log.info("Add to cart click test is finished");

    }

    @Test
    @DisplayName(value = "Buy Now click test")
    public void clickBuyNowTest(){

        log.info("Buy Now click test is started");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        productDetailsPage.clickBuyNow();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String redirect = driver.findElement(By.xpath("//h1[@class='a-spacing-small']")).getText();
        Assertions.assertThat(redirect).isEqualTo("Sign in");

        log.info("Buy Now click test is finished");

    }



    @AfterEach
    public void afterHook(){
        driver.quit();
        log.info("Web site is closed");
    }


}
