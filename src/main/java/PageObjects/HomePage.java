package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    // Class variables
    static final int TIMEOUT = 5; // 2 seconds
    static String sutUrl = "https://amazon.fr";
    // locators
    By accepTCookiesButton = By.cssSelector("input#sp-cc-accept");
    By tousMenusButton = By.cssSelector("#nav-xshop-container .nav-a");
    By bestSellBy = By.cssSelector("#nav-xshop>a:nth-child(3)");
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        /**
         * Acceder au site "amazon.fr"
         */
        driver.get(sutUrl);
    }

    public HomePage closeCookiesPopup() {
        /**
         * Accepter les cookies
         */
        driver.findElement(accepTCookiesButton).click();
        return this;
    }

    public BestSellPage goToBestSellPage() {
        driver.findElement(tousMenusButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(bestSellBy)).click();
        return new BestSellPage(driver);
    }
}
