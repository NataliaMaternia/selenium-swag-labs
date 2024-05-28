package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
public class CompletePage {

    private WebDriver driver;

    public CompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyIfOrderIsComplete() {
        WebElement checkoutCompleteOrder = driver.findElement(By.cssSelector(".complete-header"));
        String orderElementText = checkoutCompleteOrder.getText();
        assertThat(orderElementText.contains("Thank you for your order!")).isTrue();

    }
}
