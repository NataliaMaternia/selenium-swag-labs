import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }


    public void backButton() throws InterruptedException {
        WebElement backButton = driver.findElement(By.id("back-to-products"));
        backButton.click();
        TimeUnit.SECONDS.sleep(1);
    }

    public void removeProductFromCart() {
        WebElement removeButton = driver.findElement(By.cssSelector(".inventory_details_desc_container button"));
        removeButton.click();
    }

}
