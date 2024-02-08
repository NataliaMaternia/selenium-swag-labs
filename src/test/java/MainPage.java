import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.ListIterator;
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
        for (int x = 1; x <= productList.size(); x++){
            WebElement productLink = driver.findElement(By.cssSelector("div.inventory_item:nth-child(" + x + ") a"));
            productLink.click();
            TimeUnit.SECONDS.sleep(1);
            WebElement backButton = driver.findElement(By.id("back-to-products"));
            backButton.click();
            TimeUnit.SECONDS.sleep(1);

        }


        }





    }



