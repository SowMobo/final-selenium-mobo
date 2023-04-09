package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage{
    By productTitles = By.cssSelector(".a-truncate.sc-grid-item-product-title");
    By cartItemsBy = By.cssSelector("#sc-active-cart .sc-list-item-content-inner");
    By quantityBy = By.cssSelector(".a-dropdown-prompt");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle(int index) {
//        WebElement cardItem = wait.until(ExpectedConditions.presenceOfElementLocated(cartItemsBy));
//        String subTitle = cardItem.findElement(ordersTitle).getText();
        String subTitle = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productTitles))
                .get(index).getText();
        return subTitle.substring(0, subTitle.length() - 1);
    }

    public String getQuantity(int productIndex) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(quantityBy))
                .get(productIndex).getText();
    }
}
