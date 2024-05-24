package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Epic("basic functionality")
@Feature("Sauce Page Test")
public class CheckoutPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private OverviewPage overviewPage;

    @BeforeEach
    void setup() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        overviewPage = new OverviewPage(driver);
    }
    @AfterEach
    void tearDown() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void fillUserInformationAndClickContinueButton() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        mainPage.clickOnFirstProduct();
        mainPage.clickOnShoppingCart();
        cartPage.clickOnCheckoutButton();
        // when
        checkoutPage.fillUserInformation();
        checkoutPage.clickContinueButton();
        // then
        overviewPage.verifyIfCheckoutOverviewIsVisible();

    }

    @Test
    public void clickOnCancelButton() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        mainPage.clickOnFirstProduct();
        mainPage.clickOnShoppingCart();
        cartPage.clickOnCheckoutButton();
        // when
        checkoutPage.clickOnCancelButton();
        // then
        cartPage.verifyIfYourCartElementIsVisible();
    }
}
