package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerServicePage {
    static final int TIMEOUT = 5; // 2 seconds
    WebDriver driver;
    WebDriverWait wait;

    public CustomerServicePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }
}
