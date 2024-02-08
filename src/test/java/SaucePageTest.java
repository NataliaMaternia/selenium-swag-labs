import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SaucePageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = WebDriverManager.chromedriver().create();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
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
    public void clickOnProductsAndBack () throws InterruptedException {
        loginPage.loginWithCorrectCredentials();
        mainPage.clickOnProductsAndBack();
    }



}
