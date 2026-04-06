package pages;

import abstractComponents.AbstartctComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends AbstartctComponents {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By countryField = By.cssSelector("input[placeholder='Select Country']");
    private By countryResult = By.xpath("//button[contains(@class,'ta-item') and contains(.,'India')]");
    private By placeOrderButton = By.xpath("//a[normalize-space()='Place Order']");

    public void selectCountry(String countryName) {
        type(countryField, countryName);
        waitForElementToAppear(countryResult);
        click(countryResult);
    }

    public ConfirmationPage submitOrder() {
        click(placeOrderButton);
        return new ConfirmationPage(driver);
    }
}