package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AllMenuPage {
    static final int TIMEOUT = 5; // 2 seconds
    WebDriver driver;
    WebDriverWait wait;
    // locators
    By optionButtonsBy = By.cssSelector(".hmenu-visible>li .hmenu-item");

    public AllMenuPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    private void openPageBy(int index) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(optionButtonsBy))
                .get(index).click();
    }

    public BestSellPage openBestSellPage() {
        this.openPageBy(1);
        return new BestSellPage(driver);
    }

    public GamesAndConsolesPage openAllGamesAndConsolesPage() {
        this.openPageBy(16);
        // A sleep seems the better solution to handle this transition. After simulation,
        // the minimum wait is turn out to be 300 ms
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.openPageBy(2);
        return new GamesAndConsolesPage(driver);
    }
}
