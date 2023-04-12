package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage extends BasePage{
    // locators
    By searcResultsListBy = By.cssSelector(".s-result-item>div.sg-col-inner");
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
    public ProductPage getProduct(int productPosition) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searcResultsListBy)).
                get(productPosition).click();
        return new ProductPage(driver);
    }

}
