import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void top3SellHighTechProductSearchTest() {
        HomePage home = new HomePage(driver);
        ProductPage thirdTopSellProduct = home.closeCookiesPopup()
                .openBestSellPage()
                .openHighTechPage()
                .openThirdTopSellHighTech()
                .updateQuantity(2);

        String actualProductTitle = thirdTopSellProduct.getTitle();
        String expextedProductTitle = "Chargeur Rapide USB C - Certifié MFi - Chargeur Rapide" +
                " PD 20W avec câble 6FT C vers Lightning Adaptateur de Chargeur de Type C pour " +
                "iPhone 14/14 Plus/14 Pro/14 Pro Max/13/12/11/SE/iPad Pro";
        Assert.assertEquals(actualProductTitle,expextedProductTitle,
                "Incorrect title");

        CartPage myCart = thirdTopSellProduct.addToCart()
                .openCartLowCostProduct();
        String expectedQuantity = "3";
        Assert.assertEquals(myCart.getQuantity(0), expectedQuantity,
                "The quantity has changed");
        String actualSubTitle = myCart.getProductTitle(0);
        Assert.assertTrue(expextedProductTitle.contains(actualSubTitle),
                "Expected title do not contain the actual sub title. Actual sub title is:" +
                        actualSubTitle);
    }

    @AfterTest
    public void teardown() {

        driver.quit();
    }
}

