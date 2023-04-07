package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    static final int TIMEOUT = 15; // 2 seconds
    WebDriver driver;
    WebDriverWait wait;
    By productTitle = By.cssSelector("#productTitle");
    By addToCartButton = By.cssSelector("input#add-to-cart-button");
    By nonMerciButton = By.cssSelector("span#attachSiNoCoverage");
    //locator 1:  #sw-gtc #nav-cart
    //locator 2: span#attach-sidesheet-view-cart-button
    By openCartButton = By.cssSelector("span#attach-sidesheet-view-cart-button");

    By quantityBy = By.cssSelector("#quantity");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public String getTitle() {

        return wait.until(ExpectedConditions.presenceOfElementLocated(productTitle)).getText();
    }

    public ProductPage updateQuantity(int newQuantity) {
        WebElement quantitySelectTag = driver.findElement(quantityBy);
        Select dropdownQuantity =  new Select(quantitySelectTag);
        dropdownQuantity.selectByIndex(newQuantity);
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

    public CartPage openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(openCartButton)).click();
        return new CartPage(driver);
    }
}

