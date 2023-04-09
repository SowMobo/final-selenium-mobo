package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    // Class variables
    static final int TIMEOUT = 5; // 2 seconds
    // locators
    WebDriver driver;
    WebDriverWait wait;
    Header header;
    By accepTCookiesButton = By.cssSelector("input#sp-cc-accept");
    By tousMenusButton = By.cssSelector("#nav-xshop-container .nav-a");
    By bestSellBy = By.cssSelector("#nav-xshop>a:nth-child(3)");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        header = new Header(driver);
        /**
         * Acceder au site "amazon.fr"
         */
        driver.get("https://amazon.fr");
    }

    public HomePage closeCookiesPopup() {
        /**
         * Accepter les cookies
         */
        driver.findElement(accepTCookiesButton).click();
        return this;
    }
    public AllMenuPage openAllMenuPage() {
        return header.openAllMenuPage();
    }

    public BestSellPage openBestSellPage() {
        return header.openBestSellPage();
    }

    public CustomerServicePage opencustomerService() {
        return header.opencustomerService();
    }

}
