package pages;

import abstractComponents.AbstartctComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ElementClickInterceptedException;

import java.util.List;

public class ProductCataloguePage extends AbstartctComponents {

    WebDriver driver;

    public ProductCataloguePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By productCards = By.cssSelector(".card-body");
    private By productName = By.tagName("h5");
    private By addToCartButton = By.cssSelector("button.btn.w-10.rounded");
    private By toastMessage = By.cssSelector("#toast-container");
    private By spinner = By.cssSelector(".ng-animating");
    private By cartButton = By.xpath("//button[@routerlink='/dashboard/cart']");

    public List<WebElement> getProductCards() {
        waitForElementToAppear(productCards);
        return driver.findElements(productCards);
    }

    public void addProductsToCart(List<String> expectedProducts) {
        List<WebElement> allProducts = getProductCards();

        for (WebElement productCard : allProducts) {
            String currentProductName = productCard.findElement(productName).getText();
            System.out.println(currentProductName);

            boolean isRequiredProduct = expectedProducts.stream()
                    .anyMatch(expected -> expected.equalsIgnoreCase(currentProductName));

            if (isRequiredProduct) {
                WebElement addButton = productCard.findElement(addToCartButton);

                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView({block: 'center'});", addButton);

                try {
                    addButton.click();
                } catch (ElementClickInterceptedException e) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addButton);
                }

                waitForElementToAppear(toastMessage);
                waitForElementToDisappear(spinner);
            }
        }
    }

    public CartPage goToCartPage() {
        click(cartButton);
        return new CartPage(driver);
    }
}