package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GamesAndConsolesPage extends BasePage{

    By topSellItemsBy = By.cssSelector(".octopus-pc-card-content li");
    public GamesAndConsolesPage(WebDriver driver) {
        super(driver);
    }

    private void openProductPageBy(int index) {
        setTIMEOUT(10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(topSellItemsBy)).get(index).click();
    }

    public ProductPage openTopSellProduct() {
        this.openProductPageBy(0);
        return new ProductPage(driver);
    }
}
