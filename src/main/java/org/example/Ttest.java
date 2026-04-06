package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Ttest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=0.95");
        WebDriver driver=new ChromeDriver(options);
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
//
//
////        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
////
////        driver.findElement(By.id("firstName")).sendKeys("Karthik");
////        driver.findElement(By.id("lastName")).sendKeys("Sivakumar");
////        driver.findElement(By.id("userEmail")).sendKeys("karthik.sivakuma@gmail.com");
////        driver.findElement(By.id("userMobile")).sendKeys("8754257575");
////
////
////        WebElement opt=driver.findElement(By.xpath("//select[@class='custom-select ng-untouched ng-pristine ng-valid']"));
////
////        Select option=new Select(opt);
////        option.selectByVisibleText("Engineer");
////
////        driver.findElement(By.xpath("//input[@value='Male']")).click();
////
////        driver.findElement(By.id("userPassword")).sendKeys("Karthik@27");
////
////        driver.findElement(By.id("confirmPassword")).sendKeys("Karthik@27");
////
////        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
////
////        driver.findElement(By.xpath("//input[@id='login']")).click();
////
////        driver.findElement(By.xpath("//button[text()='Login']")).click();
//
//        String[] product={"ZARA COAT 3","iphone 13 pro"};
//
//        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("karthik.sivakuma@gmail.com");
//
//        driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Karthik@27");
//
//        driver.findElement(By.xpath("//input[@id='login']")).click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body")));
//
//        int productCount = driver.findElements(By.cssSelector(".card-body")).size();
//
//        for (int i = 0; i < productCount; i++) {
//
//            List<WebElement> prolists = driver.findElements(By.cssSelector(".card-body"));
//            WebElement products = prolists.get(i);
//
//            String productName = products.findElement(By.tagName("h5")).getText();
//            System.out.println(productName);
//
//            for(int j=0;j<product.length;j++){
//                if(product[j].equalsIgnoreCase(productName)){
//                    WebElement addToCartBtn = products.findElement(By.cssSelector("button.btn.w-10.rounded"));
//                    wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
//
//                    // wait for confirmation toast
//                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//
//                    // wait for loading animation to disappear
//                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
//                    break;
//                }
//            }
//        }
//
//        driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
//
//        List<WebElement> confmproduct=driver.findElements(By.xpath("//div[@class='cart']//h3"));
//
//        List<String> actualCartProducts = new ArrayList<>();
//
//        for (WebElement item : confmproduct) {
//            actualCartProducts.add(item.getText().toLowerCase());
//        }
//
//        for (int i = 0; i < product.length; i++) {
//            Assert.assertTrue(
//                    actualCartProducts.contains(product[i].toLowerCase()),
//                    product[i] + " is not present in cart"
//            );
//        }
//
//        driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
//
//        driver.findElement(By.xpath("//body[1]/app-root[1]/app-order[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/form[1]/div[1]/div[2]/div[2]/input[1]")).sendKeys("2705");
//
//        driver.findElement(By.xpath("//body[1]/app-root[1]/app-order[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/form[1]/div[1]/div[3]/div[1]/input[1]")).sendKeys("Karthik");
//
//        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Indi");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='payment__shipping']//button[1]"))).click();
//
//        driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
//
//        String orderplaced=driver.findElement(By.xpath("//h1[normalize-space()='Thankyou for the order.']")).getText();
//
//        Assert.assertTrue(orderplaced.equalsIgnoreCase("Thankyou for the order."));
//
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");

        List<String> expectedProducts = List.of("ZARA COAT 3", "iphone 13 pro");

        driver.findElement(By.id("userEmail")).sendKeys("karthik.sivakuma@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Karthik@27");
        driver.findElement(By.id("login")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body")));

        List<WebElement> productCards = driver.findElements(By.cssSelector(".card-body"));

        for (WebElement productCard : productCards) {
            String productName = productCard.findElement(By.tagName("h5")).getText();
            System.out.println(productName);

            boolean isRequiredProduct = expectedProducts.stream()
                    .anyMatch(expected -> expected.equalsIgnoreCase(productName));

            if (isRequiredProduct) {
                WebElement addToCartBtn = productCard.findElement(By.cssSelector("button.btn.w-10.rounded"));
                wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
            }
        }

        driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

        List<String> actualCartProducts = driver.findElements(By.cssSelector(".cart h3"))
                .stream()
                .map(item -> item.getText().toLowerCase())
                .toList();

        expectedProducts.forEach(expectedProduct ->
                Assert.assertTrue(
                        actualCartProducts.contains(expectedProduct.toLowerCase()),
                        expectedProduct + " is not present in cart"
                )
        );

        driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();

        driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("Indi");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(@class,'ta-item') and contains(.,'India')]")
        )).click();

        driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();

        String orderPlacedMessage = driver.findElement(
                By.cssSelector("h1.hero-primary")
        ).getText();

        Assert.assertTrue(
                orderPlacedMessage.equalsIgnoreCase("Thankyou for the order."),
                "Order confirmation message mismatch. Actual message: " + orderPlacedMessage
        );

        System.out.println("Order placed successfully.");

        driver.quit();
    }
}
