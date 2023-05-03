package com.sauce.pages;

import com.sauce.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//*[@class='title']")
    public WebElement productTitle;

    @FindBy(css = ".product_sort_container")
    public WebElement dropdownSort;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement basket;

    @FindBy(xpath = "//*[@class='inventory_list']/div")
    public List<WebElement> allProducts;

    public static double totalPrice=0.0;

    public void sortProducts(String sortType) {
        Select select = new Select(dropdownSort);
        select.selectByVisibleText(sortType);
    }

    public void addProduct(String price) {
        Driver.get().findElement(By.xpath("//*[text()='"+price+"']/../button")).click();
    }


    public void addProduct2(String product) {
        System.out.println(allProducts.size());

        int num;
        if (product.equalsIgnoreCase("cheapest")){
            num=allProducts.size();
        }else if(product.equalsIgnoreCase("most expensive")){
            num=1;
        }else {
            num = Integer.parseInt(product);
        }
        Driver.get().findElement(By.xpath("//*[@class='inventory_list']/div["+num+"]//button")).click();

        System.out.println(Driver.get().findElement(By.xpath("(//*[@class='pricebar'])["+num+"]/div")).getText());
        String $price = Driver.get().findElement(By.xpath("(//*[@class='pricebar'])["+num+"]/div")).getText();
        totalPrice += Double.parseDouble($price.substring(1));
    }
}
