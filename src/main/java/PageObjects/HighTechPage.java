package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HighTechPage extends BasePage {
    By itemButtonsBy = By.cssSelector("#zg-right-col #gridItemRoot");

    public HighTechPage(WebDriver driver) {
        super(driver);
    }

    public void openProductPageBy(int index) {
        setTIMEOUT(10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemButtonsBy)).get(index).click();
    }

    public ProductPage openThirdTopSellHighTech() {
        this.openProductPageBy(2);
        return new ProductPage(driver);
    }

}
