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

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProductDetailsPageFactoryTest {

    private static final Logger log = LogManager.getLogger(ProductDetailsPageFactoryTest.class);
    private WebDriver driver;
    private ProductDetailsPageFactory productDetailsPageFactory;

    @BeforeEach
    public void beforeHook() {

        driver = new ChromeDriver();
        productDetailsPageFactory = new ProductDetailsPageFactory(driver);
        driver.get("https://www.amazon.com/TMKB-Keyboard-Ultra-Compact-Mechanical-T68SE/dp/B0BHSSZ8NJ/ref=sr_1_1_sspa");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        log.info("Web site is opened");
    }

    @Test
    @DisplayName(value = "Product title name test")
    public void pdpNameTest(){

        log.info("Product title name test is started");

        String text = productDetailsPageFactory.getPdpText();

        productDetailsPageFactory.getPdpText();

        Assertions.assertThat(text).isEqualTo("TMKB 60 Percent Keyboard,Gaming Keyboard 60 Percent, LED Backlit Ultra-Compact 68 Keys Gaming Mechanical Keyboard with Separate Arrow/Control Keys, T68SE, Brown Switch");

    }

    @Test
    @DisplayName(value = "Add to cart click test")
    public void clickAddToCart(){

        log.info("Add to cart click test is started");

        productDetailsPageFactory.clickAddToCart();

        String successMessage = driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")).getText();
        Assertions.assertThat(successMessage).isEqualTo("Added to Cart");

    }

    @Test
    @DisplayName(value = "Buy Now click test")
    public void clickBuyNowTest(){

        log.info("Buy Now click test is started");

        productDetailsPageFactory.clickBuyNow();

        String redirect = driver.findElement(By.xpath("//h1[@class='a-spacing-small']")).getText();
        Assertions.assertThat(redirect).isEqualTo("Sign in");

    }

    @AfterEach
    public void afterHook(){
        driver.quit();
        log.info("Web site is closed");
    }

}
