package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage {
    private static final String PAGE_ADDRESS = "https://www.saucedemo.com/";
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageAndCorrectlyLogin() {
        openPage();
        loginWithCorrectCredentials();
        clickSignInButton();
    }

    public void openPage() {
        driver.get(PAGE_ADDRESS);
    }

    public void verifyUrlAfterOpenPage() {
        String expectedUrl = "https://www.saucedemo.com/";
        String currenrUrl = driver.getCurrentUrl();
        assertThat(currenrUrl)
                .as("url address error").isEqualTo(expectedUrl);
    }

    public void clickSignInButton(){
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    public void loginWithCorrectCredentials() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
    }

    public void loginWithIncorrectPassword() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("invalidPassword");
    }

    public void checkIncorrectPasswordBannerIsDisplayed() {
        WebElement incorrectPasswordBanner = driver
                .findElement(By.cssSelector(".error-message-container"));
        assertThat(incorrectPasswordBanner.isDisplayed()).isTrue();
        assertThat(incorrectPasswordBanner.getText())
                .contains("Username and password do not match any user in this service");
    }
}
