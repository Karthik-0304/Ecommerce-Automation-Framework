package pages;

import abstractComponents.AbstartctComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends AbstartctComponents {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By userEmail = By.id("userEmail");
    private By userPassword = By.id("userPassword");
    private By loginButton = By.id("login");

    public void goTo(String url) {
        driver.get(url);
    }

    public ProductCataloguePage loginApplication(String email, String password) {
        type(userEmail, email);
        type(userPassword, password);
        click(loginButton);
        return new ProductCataloguePage(driver);
    }
}