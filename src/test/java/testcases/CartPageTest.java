package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pages.*;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Epic("basic functionality")
@Feature("Sauce Page Test")

public class CartPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeEach
    void setup() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void clickOnCheckoutButton() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        mainPage.clickOnFirstProduct();
        mainPage.clickOnShoppingCart();
        // when
        cartPage.clickOnCheckoutButton();
        // then
        checkoutPage.verifyIfcheckoutIsVisible();

    }

    @Test
    public void clickOnContinueShoppingButton() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        mainPage.clickOnFirstProduct();
        mainPage.clickOnShoppingCart();
        // when
        cartPage.clickOnContinueShoppingButton();
        // then
        mainPage.verifyIfProductsElementIsVisible();

    }

}

