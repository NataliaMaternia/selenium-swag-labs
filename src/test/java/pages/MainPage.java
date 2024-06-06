package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkLogoutButtonIsVissible() {
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutButtonIsVissible = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("logout_sidebar_link")));
        assertThat(logoutButtonIsVissible.isDisplayed()).isTrue();
    }

    public void verifyIfProductsElementIsVisible() {
        WebElement productsElement = driver.findElement(By.cssSelector(".title"));
        String productsElementText = productsElement.getText();
        assertThat(productsElementText.contains("Products")).isTrue();
    }


    public void clickOnFirstProduct() {
        List<WebElement> productList = driver.findElements(By.cssSelector(".inventory_item_label a"));
        WebElement firstProduct = productList.get(0);
        firstProduct.click();
    }

    public void addFirstProductToCart() {
        WebElement button = driver.findElement(By.cssSelector(".inventory_item_description button"));
        Assertions.assertThat(button.getText()).contains("Add to cart");
        button.click();
    }

    public void removeProductFromCart() {
        WebElement button = driver.findElement(By.cssSelector(".inventory_item_description button"));
        Assertions.assertThat(button.getText()).contains("Remove");
        button.click();
    }

    public void sortByNameAtoZ() {
        Select selectSort = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        selectSort.selectByValue("az");
    }

    public void sortByNameZtoA() {
        Select selectSort = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        selectSort.selectByValue("za");
    }

    public void sortByPriceLowToHigh() {
        Select selectSort = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        selectSort.selectByValue("lohi");
    }

    public void sortByPriceHighToLow() {
        Select selectSort = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        selectSort.selectByValue("hilo");
    }

    public void verifyIfProductsAreSortedByNameAtoZ() {
        List<WebElement> productList = driver.findElements(By.cssSelector(".inventory_item_name"));
        String firstProduct = productList.get(0).getText();
        assertThat(firstProduct.contains("Sauce Labs Backpack")).isTrue();
    }
    public void  verifyIfProductsAreSortedByNameZtoA() {
        List<WebElement> productList = driver.findElements(By.cssSelector(".inventory_item_name"));
        String firstProduct = productList.get(0).getText();
        assertThat(firstProduct.contains("T-Shirt (Red)")).isTrue();
    }
    public void verifyIfProductsAreSortedByPriceLowToHigh() {
        List<WebElement> productList = driver.findElements(By.cssSelector(".inventory_item_name"));
        String firstProduct = productList.get(0).getText();
        assertThat(firstProduct.contains("Sauce Labs Onesie")).isTrue();

    }
    public void verifyIfProductsAreSortedByPriceHighToLow() {
        List<WebElement> productList = driver.findElements(By.cssSelector(".inventory_item_name"));
        String firstProduct = productList.get(0).getText();
        assertThat(firstProduct.contains("Sauce Labs Fleece Jacket")).isTrue();
    }

    public void addAllProductsToCart() {
        List<WebElement> cartList = driver.findElements(By.cssSelector(".pricebar button"));
        for (WebElement x : cartList) {
            x.click();
        }
    }

    public void checkIfAllProductAreAddedToCart() {
        List<WebElement> addToCartButtonsList = driver.findElements(By.cssSelector(".pricebar button"));
        int allProductsCount = addToCartButtonsList.size();

        WebElement cartContainer = driver.findElement(By.id("shopping_cart_container"));
        int productsInCartCount = Integer.parseInt(cartContainer.getText());

        assertThat(allProductsCount).isEqualTo(productsInCartCount);
    }


    public void clickOnShoppingCart() {
        WebElement clickCart = driver.findElement(By.cssSelector(".shopping_cart_link"));
        clickCart.click();
    }
}




