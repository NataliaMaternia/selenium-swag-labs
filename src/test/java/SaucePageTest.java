import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SaucePageTest {

    private WebDriver driver;

    String sut = "https://www.saucedemo.com/";

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterEach
    void tearDown() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(5);
        driver.quit();
    }

    @Test
    @Order(1)
    public void verifyUrlAfterOpenMainPage() {
        driver.get(sut);
        String expectedUrl = "https://www.saucedemo.com/";
        String currenrUrl = driver.getCurrentUrl();
        Assertions.assertThat(currenrUrl)
                .as("url address error").isEqualTo(expectedUrl);
        System.out.println("test 1 finished");
    }

    @Test
    @Order(2)
    public void loginWithCorrectCredentials() throws InterruptedException {
        driver.get(sut);
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        TimeUnit.SECONDS.sleep(1);

        WebElement logoutButtonIsVissible = driver.findElement(By.id("logout_sidebar_link"));
        Assertions.assertThat(logoutButtonIsVissible.isDisplayed()).isTrue();
    }


    @Test
    @Order(2)
    public void loginWithIncorrectPassword() throws InterruptedException {
        driver.get(sut);
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("invalidPassword");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement incorrectPasswordBanner = driver.findElement(By.cssSelector(".error-message-container"));
        Assertions.assertThat(incorrectPasswordBanner.isDisplayed()).isTrue();
        Assertions.assertThat(incorrectPasswordBanner.getText()).contains("Username and password do not match any user in this service");

    }
}
