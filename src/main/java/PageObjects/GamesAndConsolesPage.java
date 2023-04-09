package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GamesAndConsolesPage {
    static final int TIMEOUT = 5; // 2 seconds
    WebDriver driver;
    WebDriverWait wait;

    public GamesAndConsolesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }
}
