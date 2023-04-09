package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BestSellPage {

    static final int TIMEOUT = 10; // 2 seconds

    WebDriver driver;
    WebDriverWait wait;
    By highTechBy = By.cssSelector("._p13n-zg-nav-tree-all_style_zg-browse-height-small__nleKL>a");

    //#zg_left_col2 div[role='treeitem']
    public BestSellPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }
    private void openPageBy(int index) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(highTechBy))
                .get(index).click();
    }

    public HighTechPage openHighTechPage() {
        this.openPageBy(19);
        return new HighTechPage(driver);
    }
}

