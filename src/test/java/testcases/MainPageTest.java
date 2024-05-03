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
        loginPage.openPageAndCorrectlyLogin();
    }
    @AfterEach
    void tearDown() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void clickOnProductsAndBack() {
        // when
        mainPage.clickOnFirstProduct();
        // then
        mainPage.verifyIfProductsElementIsVisible();
      // toDo backbutton
    }
}

