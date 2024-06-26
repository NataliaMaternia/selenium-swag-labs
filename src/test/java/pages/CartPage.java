package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnCheckoutButton() {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

    public void clickOnContinueShoppingButton() {
        WebElement checkoutButton = driver.findElement(By.id("continue-shopping"));
        checkoutButton.click();
    }

    public void verifyIfYourCartElementIsVisible() {
        WebElement yourCart = driver.findElement(By.cssSelector(".title"));
        String productsElementText = yourCart.getText();
        assertThat(productsElementText.contains("Your Cart")).isTrue();
    }
}
