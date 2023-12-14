package com.sergii.tests.factory;

import com.sergii.code.factory.ProductDetailsPageFactory;
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


public class ProductDetailsPageFactoryTest {
    private static final Logger log = LogManager.getLogger(ProductDetailsPageFactoryTest.class);
    private WebDriver driver;
    private ProductDetailsPageFactory productDetailsPageFactory;
    @BeforeEach
    public void beforeHook() {

        driver = new ChromeDriver();
        productDetailsPageFactory = new ProductDetailsPageFactory(driver);
        driver.get("https://www.amazon.com/TMKB-Keyboard-Ultra-Compact-Mechanical-T68SE/dp/B0BHSSZ8NJ/ref=sr_1_1_sspa");
        log.info("Web site is opened");
    }

    @Test
    @DisplayName(value = "Product title name test")
    public void pdpNameTest(){

        log.info("Product title name test is started");
        productDetailsPageFactory.getPdpText();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productTitle")));
        Assertions.assertThat(productDetailsPageFactory.getPdpText()).isEqualTo("TMKB 60 Percent Keyboard,Gaming Keyboard 60 Percent, LED Backlit Ultra-Compact 68 Keys Gaming Mechanical Keyboard with Separate Arrow/Control Keys, T68SE, Brown Switch");
    }
    @Test
    @DisplayName(value = "Add to cart click test")
    public void clickAddToCartTest(){

        log.info("Add to cart click test is started");
        productDetailsPageFactory.clickAddToCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS")));
        Assertions.assertThat(productDetailsPageFactory.getAddToCartMessage()).isEqualTo("Added to Cart");
    }
    @Test
    @DisplayName(value = "Buy Now click test")
    public void clickBuyNowTest(){

        log.info("Buy Now click test is started");
        productDetailsPageFactory.clickBuyNow();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("authportal-main-section")));
        Assertions.assertThat(productDetailsPageFactory.getBuyNowConfirm()).isEqualTo("Sign in\n" +
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
