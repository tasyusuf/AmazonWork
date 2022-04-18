package com.pages;

import com.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends BasePage{



    @FindBy(css = "#quantity")
    public WebElement selectQnt;

    @FindBy(css = "#sc-subtotal-amount-buybox>span")
    public WebElement totalPrice;

    public String getSelectedQuantity(){
        BrowserUtils.waitFor(5);
        select = new Select(selectQnt);
        String quantity = select.getFirstSelectedOption().getText();
        return quantity;
    }

    public void changeSelection(String quantity){
        select = new Select(selectQnt);
        select.selectByVisibleText(quantity);
    }

    public Double getTotalPrice(){
        String price = totalPrice.getText();
        price = price.substring(1);
        return Double.parseDouble(price);
    }



}
