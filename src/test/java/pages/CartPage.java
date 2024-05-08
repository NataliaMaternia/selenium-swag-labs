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

    public void clickCartButton() throws InterruptedException {
        WebElement cartButton = driver.findElement(By.cssSelector(".shopping_cart_link"));
        cartButton.click();
    }

    public void verifyIfYourCartElementIsVisible() {
        WebElement yourCart = driver.findElement(By.cssSelector(".title"));
        String productsElementText = yourCart.getText();
        assertThat(productsElementText.contains("Your Cart")).isTrue();
    }
}
