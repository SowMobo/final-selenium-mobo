package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage{
    By productTitle = By.cssSelector("#productTitle");
    By addToCartButton = By.cssSelector("input#add-to-cart-button");
    By nonMerciButton = By.cssSelector("span#attachSiNoCoverage");
    //locator 1:  #sw-gtc #nav-cart
    //locator 2: span#attach-sidesheet-view-cart-button
    By expensiveProductOpenCartButton = By.cssSelector("span#attach-sidesheet-view-cart-button");
    By lowCostProductOpenCartButtonBy = By.cssSelector("#sw-gtc.a-button");
    By quantityBy = By.cssSelector("#addToCart #quantity");
    By productPriceBy = By.cssSelector("span.priceToPay");
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(productTitle)).getText();
    }

   public ProductPage updateQuantity(int newQuantity) {
        this.setTIMEOUT(10);
        WebElement quantitySelectorTag = wait.until(ExpectedConditions.presenceOfElementLocated(quantityBy));
        Select dropdownQuantityTag = new Select(quantitySelectorTag);
        dropdownQuantityTag.selectByIndex(newQuantity);
        return this;
   }

    public ProductPage addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        return this;
    }
    public ProductPage notAcceptInsurance() {
        wait.until(ExpectedConditions.elementToBeClickable(nonMerciButton)).click();
        return this;
    }

    public CartPage openCartExpensiveProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(expensiveProductOpenCartButton)).click();
        return new CartPage(driver);
    }

    public CartPage openCartLowCostProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(lowCostProductOpenCartButtonBy)).click();
        return new CartPage(driver);
    }

    public String getPrice() {
        String actualPrice = driver.findElement(productPriceBy).getText();
        return actualPrice.replace('\n', '.');
    }
}

