package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HighTechPage {
    static final int TIMEOUT = 5; // 2 seconds

    WebDriver driver;
    WebDriverWait wait;
    By itemButtonsBy = By.cssSelector("#zg-right-col #gridItemRoot");
    By thirstHighTechSellItemBy = By.cssSelector("#p13n-asin-index-2");

    public HighTechPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }
    
    public void openProductPageBy(int index) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemButtonsBy)).get(index).click();
    }

    public ProductPage openThirdTopSellHighTech() {
        this.openProductPageBy(2);
        return new ProductPage(driver);
    }

}
