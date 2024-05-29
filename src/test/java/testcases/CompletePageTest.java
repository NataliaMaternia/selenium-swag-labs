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
public class CompletePageTest {

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
    public void clickOnBackHomeButton() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        mainPage.clickOnShoppingCart();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillUserInformation();
        checkoutPage.clickContinueButton();
        overviewPage.clickOnFinishButton();
        // when
        completePage.clickOnHomeButton();
        // then
        mainPage.verifyIfProductsElementIsVisible();
    }
}
