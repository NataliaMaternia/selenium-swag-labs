import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SaucePageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;
    private CartPage cartPage;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = WebDriverManager.chromedriver().create();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterEach
    void tearDown() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(5);
        driver.quit();
    }

    @Test
    @Order(1)
    public void verifyUrlAfterOpenMainPage() {
        loginPage.loginWithIncorrectPassword();
    }

    @Test
    @Order(2)
    public void loginWithCorrectCredentials() throws InterruptedException {
        loginPage.verifyUrlAfterOpenMainPage();
        loginPage.loginWithCorrectCredentials();
        mainPage.checkLogoutButtonIsVissible();
    }

    @Test
    @Order(3)
    public void loginWithIncorrectPassword() {
        loginPage.loginWithIncorrectPassword();
        loginPage.checkIncorrectPasswordBannerIsDisplayed();
    }

    @Test
    @Order(4)
    public void clickOnProductsAndBack() throws InterruptedException {
        loginPage.loginWithCorrectCredentials();
        mainPage.clickOnProductsAndBack();
    }

    @Test
    @Order(5)
    public void addProductstoCart() throws InterruptedException {
        loginPage.loginWithCorrectCredentials();
        mainPage.addAllProductstoCart();
    }

    @Test
    @Order(6)
    public void productIsVissibleinCartAfterAdding() throws InterruptedException {
        loginPage.loginWithCorrectCredentials();
        mainPage.productIsVissibleinCartAfterAdding();
    }

    @Test
    @Order(7)
    public void removeProductFromCart() throws InterruptedException {
        loginPage.loginWithCorrectCredentials();
        mainPage.productIsVissibleinCartAfterAdding();
        productPage.removeProductFromCart();
    }

    @Test
    @Order(8)
    public void clickCheckoutButton() throws InterruptedException {
        loginPage.loginWithCorrectCredentials();
        cartPage.clickCartButton();
        checkoutPage.clickCheckoutButton();
    }

    @Test
    @Order(9)
    public void fillUserInformation() throws InterruptedException {
        loginPage.loginWithCorrectCredentials();
        cartPage.clickCartButton();
        checkoutPage.clickCheckoutButton();
        checkoutPage.fillUserInformation();
    }
}
