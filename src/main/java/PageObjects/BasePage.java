package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private int TIMEOUT = 5;
    WebDriver driver;
    WebDriverWait wait;
    // CSSLocators
    By homePageButtonBy = By.cssSelector("#nav-logo-sprites");
    By allMenu = By.cssSelector("#nav-hamburger-menu");
    By shopsButtonBy = By.cssSelector("#nav-xshop a.nav-a");
    By searchTextBoxBy = By.cssSelector("input#twotabsearchtextbox");
    By searchLoupBy = By.cssSelector("input#nav-search-submit-button");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public void setTIMEOUT(int timeout) {
        this.TIMEOUT = timeout;
    }

    /**
     * This function open a page based on its position(0-based index)
     * in second middle menu of header
     * e.g shopIndex(0) will open the bestSellPage
     * index is between 0 and 8
     *
     * @param shopIndex
     */
    public void openShopBy(int shopIndex) {
        driver.findElements(shopsButtonBy).get(shopIndex).click();
    }

    public AllMenuPage openAllMenuPage() {
        driver.findElement(allMenu).click();
        return new AllMenuPage(driver);
    }

    public BestSellPage openBestSellPage() {
        this.openShopBy(0);
        return new BestSellPage(driver);
    }

    public CustomerServicePage opencustomerService() {
        this.openShopBy(1);
        return new CustomerServicePage(driver);
    }

    public SearchResultsPage searchItemBy(String keyword) {
        setTIMEOUT(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(searchTextBoxBy)).sendKeys(keyword);
        driver.findElement(searchLoupBy).click();
        return new SearchResultsPage(driver);
    }

}
