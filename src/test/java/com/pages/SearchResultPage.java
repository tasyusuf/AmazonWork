package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@data-component-type='s-search-result'][1]//img")
    public WebElement firstResult;
}