package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BestSellPage extends BasePage {
    By highTechPageBy = By.cssSelector("#zg_left_col2 a");

    public BestSellPage(WebDriver driver) {
        super(driver);
    }

    private void openPageBy(int index) {
        setTIMEOUT(10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(highTechPageBy))
                .get(index).click();
    }

    public HighTechPage openHighTechPage() {
        this.openPageBy(19);
        return new HighTechPage(driver);
    }
}

