package com.sauce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage{
    @FindBy(css = "#checkout")
    public WebElement checkout;

    @FindBy(css = "#first-name")
    public WebElement firstNameInput;

    @FindBy(css = "#last-name")
    public WebElement lastNameInput;

    @FindBy(css = "#postal-code")
    public WebElement postCodeInput;

    @FindBy(css = "#continue")
    public WebElement continueBtn;

    @FindBy(css = ".summary_info_label.summary_total_label")
    public  WebElement totalPrice;

    @FindBy(css = "#finish")
    public  WebElement finishBtn;

    @FindBy(css = ".complete-header")
    public  WebElement confirmationMessage;



    public void entersDetails(String firstname,String lastname,String postcode){
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        postCodeInput.sendKeys(postcode);
    }
}
