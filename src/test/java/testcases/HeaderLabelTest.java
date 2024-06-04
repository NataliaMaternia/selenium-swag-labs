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

public class HeaderLabelTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private HeaderLabelPage headerLabelPage;

    @BeforeEach
    void setup() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        headerLabelPage = new HeaderLabelPage(driver);
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void clickOnBurgerMenu() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        // when
        headerLabelPage.clickOnBurgerMenu();
        // then
        headerLabelPage.checkIfBurgerMenuIsUnfolded();
    }

    @Test
    public void clickOnLogout() {
        // given
        loginPage.openPageAndCorrectlyLogin();
        headerLabelPage.clickOnBurgerMenu();
        // when
        headerLabelPage.clickOnlogout();
        // then
       loginPage.checkIfSignInButtonIsVissible();

    }


}
