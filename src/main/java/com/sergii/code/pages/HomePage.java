package com.sergii.code.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private static final By TEXT = By.xpath("//*[text()='Make Money with Us']");

    private static final By TITLE = By.xpath("//span[normalize-space()='Dresses under $30']");

    private static final By CART = By.xpath("//span[normalize-space()='Cart']");

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getText() {
       return driver.findElement(TEXT).getText();
    }

    public void clickTitle() {
        driver.findElement(TITLE).click();
    }

    public void clickCart() {
        driver.findElement(CART).click();
    }

}
