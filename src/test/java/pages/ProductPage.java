package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOnBackButton() throws InterruptedException {
        WebElement backButton = driver.findElement(By.id("back-to-products"));
        backButton.click();
    }

    public void addProductToCart() {
        WebElement button = driver.findElement(By.cssSelector(".inventory_details_desc_container button"));
        Assertions.assertThat(button.getText()).contains("Add to cart");
        button.click();
    }

    public void checkIfShoppingCartIsNotEmpty() {
        WebElement button = driver.findElement(By.id("shopping_cart_container"));
        Assertions.assertThat(button.getText()).isNotEmpty();
        }

    public void removeProductFromCart() {
        WebElement button = driver.findElement(By.cssSelector(".inventory_details_desc_container button"));
        Assertions.assertThat(button.getText()).contains("Remove");
        button.click();
    }
    public void checkIfShoppingCartIsEmpty() {
        WebElement button = driver.findElement(By.id("shopping_cart_container"));
        Assertions.assertThat(button.getText()).isEmpty();
    }



}

