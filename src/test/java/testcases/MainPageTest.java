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

public class MainPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private HeaderLabelPage headerLabelPage;

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
        cartPage = new CartPage(driver);
        headerLabelPage = new HeaderLabelPage(driver);
    }
    @AfterEach
    void tearDown() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void clickOnFirstProductAndBack() throws InterruptedException {
        // given
        loginPage.openPageAndCorrectlyLogin();
        // when
        mainPage.clickOnFirstProduct();
        productPage.clickOnBackButton();
        // then
        mainPage.verifyIfProductsElementIsVisible();
    }

    @Test
    public void addProductToCartAtMainPage() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        // when
        mainPage.addFirstProductToCart();
        // then
        headerLabelPage.checkIfShoppingCartIsNotEmpty();
    }

    @Test
    public void addAllProductsToCart() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        // when
        mainPage.addAllProductsToCart();
        // then
        mainPage.checkIfAllProductAreAddedToCart();
    }

    @Test
    public void removeProductFromCartAMainPage() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        mainPage.addFirstProductToCart();
        // when
        mainPage.removeProductFromCart();
        // then
        headerLabelPage.checkIfShoppingCartIsEmpty();
    }

    @Test
    public void clickOnShoppingCart() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        // when
        mainPage.clickOnShoppingCart();
        // then
        cartPage.verifyIfYourCartElementIsVisible();
    }

    @Test
    public void sortByNameAtoZ() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        // when
        mainPage.sortByNameAtoZ();
        // then
        mainPage.verifyIfProductsAreSortedByNameAtoZ();
    }

    @Test
    public void sortByNameZtoA() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        // when
        mainPage.sortByNameZtoA();
        // then
        mainPage.verifyIfProductsAreSortedByNameZtoA();

    }

    @Test
    public void sortByPriceLowToHigh() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        // when
        mainPage.sortByPriceLowToHigh();
        // then
        mainPage.verifyIfProductsAreSortedByPriceLowToHigh();
    }

        @Test
        public void sortByPriceHighToLow() {
            // given
            loginPage.openPageAndCorrectlyLogin();
            // when
            mainPage.sortByPriceHighToLow();
            // then
            mainPage.verifyIfProductsAreSortedByPriceHighToLow();
    }
}

