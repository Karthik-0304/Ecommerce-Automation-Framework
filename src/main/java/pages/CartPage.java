package pages;

import abstractComponents.AbstartctComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends AbstartctComponents {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By cartProducts = By.cssSelector(".cartSection h3");
    By checkoutButton = By.xpath("//button[normalize-space()='Checkout']");

    public Boolean verifyProductInCart(String expectedProduct) {
        List<WebElement> products = driver.findElements(cartProducts);

        return products.stream()
                .anyMatch(product -> product.getText().equalsIgnoreCase(expectedProduct));
    }

    public CheckoutPage goToCheckout() {
        WebElement checkout = driver.findElement(checkoutButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", checkout);
        click(checkoutButton);
        return new CheckoutPage(driver);
    }
}