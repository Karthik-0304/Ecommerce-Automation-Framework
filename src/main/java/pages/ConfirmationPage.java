package pages;

import abstractComponents.AbstartctComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends AbstartctComponents {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By confirmationMessage = By.cssSelector("h1.hero-primary");

    public String getConfirmationMessage() {
        return getText(confirmationMessage);
    }
}