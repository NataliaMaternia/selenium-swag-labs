package testcases;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pages.*;
import java.time.Duration;
public class ProductPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
    }

    @BeforeEach
    void setup() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
    }
    @AfterEach
    void tearDown() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void addFirstProductToCartAtProductPage() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        mainPage.clickOnFirstProduct();
        // when
        productPage.addProductToCart();
        // then
        productPage.checkIfShoppingCartIsNotEmpty();
    }

    @Test
    public void removeProductFromCart() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        mainPage.clickOnFirstProduct();
        productPage.addProductToCart();
        // when
        productPage.removeProductFromCart();
        // then
        productPage.checkIfShoppingCartIsEmpty();
    }

    @Test
    public void clickOnBackToProductsButton() throws InterruptedException {
        // given
        loginPage.openPageAndCorrectlyLogin();
        mainPage.clickOnFirstProduct();
        // when
        productPage.clickOnBackButton();
        // then
        mainPage.verifyIfProductsElementIsVisible();
    }


}
