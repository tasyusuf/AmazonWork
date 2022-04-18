package com.tests;

import com.pages.CartPage;
import com.pages.ItemPage;
import com.pages.LandingPage;
import com.pages.SearchResultPage;
import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingTest extends TestBase{

    /*
    Task 1: The task consists on the next steps:
    1. Go to https://www.amazon.com
    2. Search for "hats for men" (Call from Configuration.properties file)
    3. Add the first hat appearing to Cart with quantity 2
    4. Open cart and assert that the total price and quantity are correct
    5. Reduce the quantity from 2 to 1 in Cart for the item selected in the step 3
    6. Assert that the total price and quantity has been correctly changed
    The goal of this test is to check if you are able to automate a test of a given website,
    but we'd like you to also demonstrate the coding quality, structure, and style of the deliverables.

     */



    @Test
    public void test1(){
        extentLogger = report.createTest("Amazon Shopping");
        //2. Search for "hats for men" (Call from Configuration.properties file)
        LandingPage landingPage = new LandingPage();
        extentLogger.info("Searching for " + ConfigurationReader.get("purchasingItem"));
        landingPage.searchBox.sendKeys(ConfigurationReader.get("purchasingItem"));
        landingPage.searchSubmitBox.click();

        // 3. Add the first hat appearing to Cart with quantity 2
        SearchResultPage searchResultPage = new SearchResultPage();
        extentLogger.info("Choosing the first item");
        searchResultPage.firstResult.click();

        ItemPage itemPage = new ItemPage();
        extentLogger.info("Selecting 2 and adding them to the cart");

        double expectedPriceOne = itemPage.getGivenPrice();
        double expectedPrice = expectedPriceOne * Integer.parseInt(ConfigurationReader.get("amazonItemQuantity"));

        itemPage.getSelectQuantity();
        itemPage.addToCart.click();


        //  4. Open cart and assert that the total price and quantity are correct
        extentLogger.info("Navigating to Cart");
        itemPage.navCart.click();
        CartPage cartPage = new CartPage();

        extentLogger.info("Verifying the quantity");
        String expectedQuantity = ConfigurationReader.get("amazonItemQuantity");
        BrowserUtils.waitForPageToLoad(5);

        String actualQuantity = cartPage.getSelectedQuantity();


        Assert.assertEquals(actualQuantity,expectedQuantity,
                "verify actual quantity and expected quantity");
        extentLogger.pass("actual quantity and expected quantity is same: " + actualQuantity);

        extentLogger.info("verify total price is correct");
        double actualPrice = cartPage.getTotalPrice();
        Assert.assertTrue(actualPrice == expectedPrice,
                "actual price and expected price is equal.");
        extentLogger.pass("expected and actual price is same " + actualPrice);

        //5. Reduce the quantity from 2 to 1 in Cart for the item selected in the step 3
        cartPage.changeSelection(ConfigurationReader.get("amazonItemNewQuantity"));

        //6. Assert that the total price and quantity has been correctly changed


        extentLogger.info("Verifying the quantity after change in item quantity");
        expectedQuantity = ConfigurationReader.get("amazonItemNewQuantity");
        BrowserUtils.waitForPageToLoad(5);
        actualQuantity = cartPage.getSelectedQuantity();


        Assert.assertEquals(actualQuantity,expectedQuantity,
                "verify actual quantity and expected quantity");
        extentLogger.pass("actual quantity and expected quantity is same: " + actualQuantity);

        extentLogger.info("verify total price is correct after change in quantity");
        actualPrice = cartPage.getTotalPrice();
        expectedPrice = expectedPriceOne * Integer.parseInt(ConfigurationReader.get("amazonItemNewQuantity"));
        Assert.assertTrue(actualPrice == expectedPrice,
                "actual price and expected price is equal.");
        extentLogger.pass("expected and actual price is same " + actualPrice);












    }

}
