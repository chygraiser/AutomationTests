package com.sergii.code.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

        private static final By PDP_NAME = By.xpath("//h1[@id='title']");

        private static final By PDP_ADD_PRODUCT = By.xpath("//*[@id='addToCart_feature_div']");

        private static final By PDP_BUY_NOW = By.xpath("//*[@id='buy-now-button']");

        private static WebDriver driver;

        public ProductDetailsPage(WebDriver driver){
            this.driver = driver;
        }

        public static String getPdpText() {

            return driver.findElement(PDP_NAME).getText();
        }

        public void clickAddToCart() {

            driver.findElement(PDP_ADD_PRODUCT).click();

        }

        public void clickBuyNow() {

            driver.findElement(PDP_BUY_NOW).click();

        }

}
