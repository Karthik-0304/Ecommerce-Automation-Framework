package pages;

import abstractComponents.AbstartctComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CartPage extends AbstartctComponents {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By cartProducts = By.cssSelector(".cart h3");
    private By checkoutButton = By.xpath("//button[normalize-space()='Checkout']");

    public List<String> getActualCartProducts() {
        waitForElementToAppear(cartProducts);
        return driver.findElements(cartProducts)
                .stream()
                .map(item -> item.getText().toLowerCase())
                .toList();
    }

    public boolean verifyProductInCart(String expectedProduct) {
        return getActualCartProducts().contains(expectedProduct.toLowerCase());
    }

    public CheckoutPage goToCheckout() {
        click(checkoutButton);
        return new CheckoutPage(driver);
    }
}