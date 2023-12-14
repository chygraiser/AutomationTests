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

    @FindBy(id = "a-popover-header-1")
    private WebElement textCountry;

    @FindBy(id = "authportal-main-section")
    private WebElement getAccountSignIn;

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

    public String getCountryText() {
        return textCountry.getText();

    }

    public void clickAccount() {
        account.click();
    }

    public String getAccountFormConfirm() {
        return getAccountSignIn.getText();
    }
}
