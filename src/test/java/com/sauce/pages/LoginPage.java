package com.sauce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "user-name")
    public WebElement userName;

    @FindBy(css = "#password")
    public WebElement userPassword;

    @FindBy(css = "#login-button")
    public WebElement loginBtn;

    public void login(String username,String password){
        userName.sendKeys(username);
        userPassword.sendKeys(password);
        loginBtn.click();
    }


}
