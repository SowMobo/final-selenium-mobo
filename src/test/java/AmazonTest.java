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
        String expextedProductTitle = "Tapo Caméra Surveillance WiFi intérieure 1080P C200," +
                " détection de mouvement, audio bidirectionnel, compatible avec Alexa et Google" +
                " Assistant, pour Bébé/Animaux";
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
                .getProduct(0);
        // for local test use this as expectedTitle : Apple iPhone 14 Pro (128 Go) - Noir sidéral
        String expectedTitle = "Apple iPhone 14 Pro (128 Go) - Argent";
        Assert.assertEquals(product.getTitle(), expectedTitle, "Incorrect title");
        // For local test use this as expected price : 1 209.00€
        String expectedPrice = "1 081.00€";
        Assert.assertEquals(product.getPrice(), expectedPrice, "Wrong price");
        CartPage monPanier = product.addToCart()
                .notAcceptInsurance()
                .openCartExpensiveProduct();
        assertThat(expectedTitle).contains(monPanier.getProductTitle(0));
        Assert.assertEquals(monPanier.getQuantity(0), "1", "Incorrect quantity");

    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}

