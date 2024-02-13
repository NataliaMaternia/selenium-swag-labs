import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckoutButton() {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

    public void fillUserInformation() {
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Jan");
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Kowalski");
        WebElement zipCode = driver.findElement(By.id("postal-code"));
        zipCode.sendKeys("50-100");
        WebElement contineButton = driver.findElement(By.id("continue"));


    }

}


