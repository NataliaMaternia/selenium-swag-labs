import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void clickOnProductsAndBack() throws InterruptedException {
        List<WebElement> productList = driver.findElements(By.cssSelector(".inventory_item_label a"));
        for (int x = 1; x <= productList.size(); x++) {
            WebElement productLink = getProductLinkByPositionInList(x);
            productLink.click();
            new ProductPage(driver).backButton();
        }
    }

    public void addAllProductstoCart() throws InterruptedException {
        List<WebElement> cardList = driver.findElements(By.cssSelector(".pricebar button"));
        for (WebElement x : cardList) {
            x.click();
        }
    }

    public void productIsVisibleInCartAfterAdding() {
        WebElement firstProduct = driver.findElement(By.cssSelector(".inventory_item_name"));
        firstProduct.click();
        WebElement clickCart = driver.findElement(By.cssSelector(".inventory_details_desc_container button"));
        clickCart.click();
    }


    public WebElement getProductLinkByPositionInList(int positionOfProduct) {
        String selectorForProductLinkByPosition =
                "div.inventory_item:nth-child(" + positionOfProduct + ") a";
        WebElement productLink = driver.findElement(By.cssSelector(selectorForProductLinkByPosition));
        return productLink;
    }
}




