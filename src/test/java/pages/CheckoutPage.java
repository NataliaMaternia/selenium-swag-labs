package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyIfcheckoutIsVisible() {
        WebElement checkoutYourInformation = driver.findElement(By.cssSelector(".title"));
        String checkoutElementText = checkoutYourInformation.getText();
        assertThat(checkoutElementText.contains("Checkout: Your Information")).isTrue();
    }

    public void fillUserInformation() {
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Jan");
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Kowalski");
        WebElement zipCode = driver.findElement(By.id("postal-code"));
        zipCode.sendKeys("50-100");
    }

    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
    }

    public void clickOnCancelButton() {
        WebElement cancelButton = driver.findElement(By.id("cancel"));
        cancelButton.click();

    }
}


