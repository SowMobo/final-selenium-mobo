package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    // Class variables
    // locators
    By accepTCookiesButton = By.cssSelector("input#sp-cc-accept");

    public HomePage(WebDriver driver) {
        super(driver);
        /**
         * Acceder au site "amazon.fr"
         */
        this.driver.get("https://amazon.fr");
    }

    public HomePage closeCookiesPopup() {
        /**
         * Accepter les cookies
         */
        driver.findElement(accepTCookiesButton).click();
        return this;
    }

}
