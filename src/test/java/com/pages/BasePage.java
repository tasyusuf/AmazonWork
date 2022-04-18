package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public abstract class  BasePage {
    public Select select;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "#twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']")
    public WebElement searchSubmitBox;

    @FindBy(css = "#nav-cart")
    public WebElement navCart;

}
