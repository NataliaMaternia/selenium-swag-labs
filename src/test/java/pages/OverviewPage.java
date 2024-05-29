package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.assertj.core.api.Assertions.assertThat;
public class OverviewPage {
    private WebDriver driver;
    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyIfCheckoutOverviewIsVisible() {
        WebElement overviewElement = driver.findElement(By.cssSelector(".title"));
        String productsElementText = overviewElement.getText();
        assertThat(productsElementText.contains("Checkout: Overview")).isTrue();
    }
    public void clickOnCancelButton() {
        WebElement cancelButton = driver.findElement(By.id("cancel"));
        cancelButton.click();
    }

    public void clickOnFinishButton() {
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
    }

}


