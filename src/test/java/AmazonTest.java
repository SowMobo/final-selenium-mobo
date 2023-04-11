import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.ProductPage;
import PageObjects.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
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
        ProductPage thirdTopSellProduct = home.openBestSellPage()
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

    @Test
    public void searchTopSellGameAndConsoleItem() {
        HomePage home = new HomePage(driver);
        ProductPage topSellProduct = home.openAllMenuPage()
                .openAllGamesAndConsolesPage()
                .openTopSellProduct();
        String expectedTitle = "The Legend of Zelda : Tears of the Kingdom";
        Assert.assertEquals(topSellProduct.getTitle(), expectedTitle,"The title is " +
                "not as expected");
        Assert.assertEquals(topSellProduct.getPrice(), "54.99€",
                "The price has changed");
    }

    @Test
    public void searchAndAddArticleToCartByKeyword() {
        HomePage home = new HomePage(driver);
        ProductPage product = home.searchItemBy("Iphone 14 pro")
                .getProduct(0)
                .updateQuantity(1);
        String expectedTitle = "Apple iPhone 14 Pro (128 Go) - Noir sidéral";
        Assert.assertEquals(product.getTitle(), expectedTitle, "Incorrect title");
        String expectedPrice = "1 179.00€";
        Assert.assertEquals(product.getPrice(), expectedPrice, "Wrong price");
        CartPage monPanier = product.addToCart()
                .notAcceptInsurance()
                .openCartExpensiveProduct();
        assertThat(expectedTitle).contains(monPanier.getProductTitle(0));
        Assert.assertEquals(monPanier.getQuantity(0), "2", "Incorrect quantity");

    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}

