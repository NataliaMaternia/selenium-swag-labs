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

public class OverviewPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private OverviewPage overviewPage;
    private CompletePage completePage;

    @BeforeEach
    void setup() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        overviewPage = new OverviewPage(driver);
        completePage = new CompletePage(driver);
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void clickOnCancelButton() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        mainPage.clickOnShoppingCart();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillUserInformation();
        checkoutPage.clickContinueButton();
        // when
        overviewPage.clickOnCancelButton();
        //then
        mainPage.verifyIfProductsElementIsVisible();
    }

    @Test
    public void clickOnFinishButton() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        mainPage.clickOnShoppingCart();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillUserInformation();
        checkoutPage.clickContinueButton();
        // when
        overviewPage.clickOnFinishButton();
        // then
        completePage.verifyIfOrderIsComplete();
    }


}

