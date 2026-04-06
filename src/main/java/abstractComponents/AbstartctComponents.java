package abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstartctComponents {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstartctComponents(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(By locator) {
        waitForElementToBeClickable(locator);
        driver.findElement(locator).click();
    }

    public void type(By locator, String value) {
        waitForElementToAppear(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public String getText(By locator) {
        waitForElementToAppear(locator);
        return driver.findElement(locator).getText();
    }

    public void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForWebElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}