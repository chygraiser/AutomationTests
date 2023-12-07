package com.sergii.code.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {

    @FindBy(id = "glow-ingress-line1")
    private WebElement textDeliver;

    @FindBy(id = "glow-ingress-line2")
    private WebElement country;

    @FindBy(id = "nav-link-accountList-nav-line-1")

    private WebElement account;

    private WebDriver driver;

    public HomePageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getText() {
        return textDeliver.getText();
    }

    public void clickCountry() {
        country.click();
    }

    public void clickAccount() {
        account.click();
    }
}
