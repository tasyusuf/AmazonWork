package com.pages;

import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ItemPage extends BasePage{



    @FindBy(id = "add-to-cart-button")
    public WebElement addToCart;

    @FindBy(xpath = "//select[@id ='quantity']")
    public WebElement selectQuantity;

    @FindBy(xpath = "//div[@id = 'corePrice_feature_div']//span[2]")
    public WebElement priceTag;


    public void getSelectQuantity(){
        select = new Select(selectQuantity);
        select.selectByVisibleText(ConfigurationReader.get("amazonItemQuantity"));
    }

    public double getGivenPrice(){
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitForVisibility(priceTag,15);
        String price = priceTag.getText();
        price = price.substring(1);
        double givenPrice = Double.parseDouble(price);
        return givenPrice;
    }







}
