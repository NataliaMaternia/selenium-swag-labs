import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
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

    public void clickOnProductsAndBack() throws InterruptedException {
        List<WebElement> productList = driver.findElements(By.cssSelector(".inventory_item_label a"));
        for (int x = 1; x <= productList.size(); x++) {
            WebElement productLink = getProductLinkByPositionInList(x);
            productLink.click();
            TimeUnit.SECONDS.sleep(1);
            new ProductPage(driver).backButton();
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void addAllProductstoCart() throws InterruptedException {
        List<WebElement> cardList = driver.findElements(By.cssSelector(".pricebar button"));
        for (WebElement x : cardList) {
            x.click();
        }
        TimeUnit.SECONDS.sleep(10);
    }

    public void productIsVissibleinCartAfterAdding() throws InterruptedException {
        WebElement firstProduct = driver.findElement(By.cssSelector(".inventory_item_name"));
        firstProduct.click();
        WebElement clickCart = driver.findElement(By.cssSelector(".inventory_details_desc_container button"));
        clickCart.click();
        TimeUnit.SECONDS.sleep(2);
    }


    public WebElement getProductLinkByPositionInList(int positionOfProduct) {
        String selectorForProductLinkByPosition =
                "div.inventory_item:nth-child(" + positionOfProduct + ") a";
        WebElement productLink = driver.findElement(By.cssSelector(selectorForProductLinkByPosition));
        return productLink;
    }
}




