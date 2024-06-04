package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
public class HeaderLabelPage {

    private WebDriver driver;

    public HeaderLabelPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnBurgerMenu() {
        WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenu.click();
    }

    public void checkIfBurgerMenuIsUnfolded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement unfoldedMenu = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".bm-item-list")));
        assertThat(unfoldedMenu.isDisplayed()).isTrue();
    }

    public void clickOnlogout() {
        WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
        logout.click();
    }

    public void checkIfShoppingCartIsNotEmpty() {
        WebElement button = driver.findElement(By.id("shopping_cart_container"));
        Assertions.assertThat(button.getText()).isNotEmpty();
    }

    public void checkIfShoppingCartIsEmpty() {
        WebElement button = driver.findElement(By.id("shopping_cart_container"));
        Assertions.assertThat(button.getText()).isEmpty();
    }
}
