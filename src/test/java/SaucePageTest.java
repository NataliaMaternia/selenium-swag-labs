import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Epic("basic functionality")
@Feature("Sauce Page Test")
public class SaucePageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;
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
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        driver.quit();
    }

    @Test
    @Description("verify url after open main page")
    @Order(1)
    public void verifyUrlAfterOpenMainPage() {
        loginPage.loginWithIncorrectPassword();
    }

    @Test
    @Order(2)
    public void loginWithCorrectCredentials() throws InterruptedException {
        // given
        loginPage.verifyUrlAfterOpenMainPage();
        // when
        loginPage.loginWithCorrectCredentials();
        // then
        mainPage.checkLogoutButtonIsVissible();
    }

    @Test
    @Order(3)
    public void loginWithIncorrectPassword() {
        // when
        loginPage.loginWithIncorrectPassword();
        // then
        loginPage.checkIncorrectPasswordBannerIsDisplayed();
    }

    @Test
    @Order(4)
    public void clickOnProductsAndBack() throws InterruptedException {
        // given
        loginPage.loginWithCorrectCredentials();
        // when
        mainPage.clickOnProductsAndBack();
        // then
        // TODO check if more than 2 products were successfully verified
    }

    @Test
    @Order(5)
    public void addProductstoCart() throws InterruptedException {
        // given
        loginPage.loginWithCorrectCredentials();
        // when
        mainPage.addAllProductstoCart();
        // then
        // no exception thrown
    }

    @Test
    @Order(6)
    public void productIsVissibleinCartAfterAdding() throws InterruptedException {
        // given
        loginPage.loginWithCorrectCredentials();
        // when
        mainPage.productIsVisibleInCartAfterAdding();
        // then
        // TODO add assertion
    }

    @Test
    @Order(7)
    public void removeProductFromCart() throws InterruptedException {
        // given
        loginPage.loginWithCorrectCredentials();
        mainPage.productIsVisibleInCartAfterAdding();
        // when
        productPage.removeProductFromCart();
        // then
        // TODO add assertion
    }

    @Test
    @Order(8)
    public void clickCheckoutButton() throws InterruptedException {
        // given
        loginPage.loginWithCorrectCredentials();
        cartPage.clickCartButton();
        // when
        checkoutPage.clickCheckoutButton();
        // then
        // TODO add assertion
    }

    @Test
    @Order(9)
    public void fillUserInformation() throws InterruptedException {
        // given
        loginPage.loginWithCorrectCredentials();
        cartPage.clickCartButton();
        checkoutPage.clickCheckoutButton();
        // when
        checkoutPage.fillUserInformation();
        // then
        // TODO add assertion
    }
}
