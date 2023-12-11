package com.sergii.code.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPageFactory {

    @FindBy(id = "productTitle")
    private WebElement titleOfProduct;

    @FindBy(id = "buy-now-button")
    private WebElement buyNow;

    @FindBy(id = "addToCart_feature_div")
    private WebElement addToCart;

    @FindBy (id = "NATC_SMART_WAGON_CONF_MSG_SUCCESS")
    private WebElement addToCartMessage;

    @FindBy(id = "authportal-main-section")
    private WebElement getBuyNow;

    private static WebDriver driver;

    public ProductDetailsPageFactory (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPdpText() {
        return titleOfProduct.getText();
    }

    public void clickAddToCart() {
        addToCart.click();
    }

    public String getAddToCartMessage() {
        return  addToCartMessage.getText();
    }

    public void clickBuyNow() {
        buyNow.click();
    }

    public String getBuyNowConfirm() {
        return getBuyNow.getText();
    }
}
