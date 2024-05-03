package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pages.*;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Epic("basic functionality")
@Feature("Sauce Page Test")

public class FullOrderPathTest {

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
    public void loginWithCorrectCredentials() {
        // given
        loginPage.openPage();
        // when
        loginPage.loginWithCorrectCredentials();
        // then
        mainPage.checkLogoutButtonIsVissible();
    }

    @Test
    @Description("verify url after open main page")
    public void verifyUrlAfterOpenMainPage() {
    }
    @Test
    public void clickOnProductsAndBack() throws InterruptedException {
        // given
        loginPage.loginWithCorrectCredentials();
        // when
        mainPage.clickOnProductsAndBack();
        // then
        // TODO check if more than 2 products were successfully verified
    }

    @Test
    public void addProductstoCart() throws InterruptedException {
        // given
        loginPage.loginWithCorrectCredentials();
        // when
        mainPage.addAllProductstoCart();
        // then
        // no exception thrown
    }

    @Test
    public void productIsVissibleinCartAfterAdding() throws InterruptedException {
        // given
        loginPage.loginWithCorrectCredentials();
        // when
        mainPage.productIsVisibleInCartAfterAdding();
        // then
        // TODO add assertion
    }

    @Test
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