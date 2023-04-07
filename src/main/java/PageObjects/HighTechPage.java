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

    By thirstHighTechSellItemBy = By.cssSelector("#p13n-asin-index-2");

    public HighTechPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public ProductPage goToProductPage() {
        wait.until(ExpectedConditions.elementToBeClickable(thirstHighTechSellItemBy)).click();
        return new ProductPage(driver);
    }

}
