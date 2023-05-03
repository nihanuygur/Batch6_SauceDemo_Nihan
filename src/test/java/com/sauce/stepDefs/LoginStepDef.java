package com.sauce.stepDefs;

import com.sauce.pages.CheckOutPage;
import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductPage;
import com.sauce.utilities.ConfigurationReader;
import com.sauce.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    CheckOutPage checkOutPage = new CheckOutPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("The user logs in using {string} and {string} credentials")
    public void the_user_logs_in_using_and_credentials(String username, String password) {

        loginPage.login(username, password);
    }

    @Then("The user should be able to login and see {string} header")
    public void the_user_should_be_able_to_login_and_see_header(String expectedHeader) {
        assertEquals(expectedHeader, productPage.productTitle.getText());
    }

    @And("The user opens basket")
    public void theUserOpensBasket() {
        productPage.basket.click();

    }

    @And("The user clicks checkout")
    public void theUserClicksCheckout() {
        checkOutPage.checkout.click();

    }

    @And("The user enters details {string} {string} {string} and finish the purchase")
    public void theUserEntersDetailsAndFinishThePurchase(String firstName, String lastName, String postcode) {
        checkOutPage.entersDetails(firstName, lastName, postcode);
        checkOutPage.continueBtn.click();

    }

    @And("The user should be able to sort the products {string}")
    public void theUserShouldBeAbleToSortTheProducts(String sortType) {
        productPage.sortProducts(sortType);
    }

    @And("The user clicks cheapest as {string} and second costliest as {string} products")
    public void theUserClicksCheapestAsAndSecondCostliestAsProducts(String cheapest, String second) {
        productPage.addProduct2(cheapest);
        productPage.addProduct2(second);
    }


    @Then("The user verify that Total Price is ${string}")
    public void theUserVerifyThatTotalPriceIs$(String expectedPrice) {
        assertEquals(expectedPrice,checkOutPage.totalPrice.getText());

//        assertEquals(expectedPrice,"Total: $"+ProductPage.totalPrice);
//        System.out.println("Total: $"+ProductPage.totalPrice);
    }


    @And("The user clicks finish button")
    public void theUserClicksFinishButton() {
        checkOutPage.finishBtn.click();
    }

    @And("The user should be able to see confirmation message {string}")
    public void theUserShouldBeAbleToSeeConfirmationMessage(String expectedMessage) {
        assertEquals(expectedMessage,checkOutPage.confirmationMessage.getText());
    }
}
