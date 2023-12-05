package com.sergii.code.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private static final By LOGO = By.xpath("//a[@id='nav-logo-sprites']");

    private static final By TITLE = By.xpath("//img[@alt='Dresses']");

    private static final By CART = By.xpath("//span[normalize-space()='Cart']");

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getLogoText() {
       return driver.findElement(LOGO).getText();
    }

    public void clickTitle() {

        driver.findElement(TITLE).click();

    }

    public void clickCart() {

        driver.findElement(CART).click();
    }



}
