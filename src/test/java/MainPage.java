import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkLogoutButtonIsVissible() throws InterruptedException {
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        TimeUnit.SECONDS.sleep(1);
        WebElement logoutButtonIsVissible = driver.findElement(By.id("logout_sidebar_link"));
        assertThat(logoutButtonIsVissible.isDisplayed()).isTrue();
    }

}

