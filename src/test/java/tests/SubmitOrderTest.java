package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ConfirmationPage;
import pages.ProductCataloguePage;
import testComponents.BaseTest;

import java.util.HashMap;
import java.util.List;

@Listeners(testComponents.Listeners.class)
public class SubmitOrderTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void submitOrderTest(HashMap<String, Object> input) {

        String email = (String) input.get("email");
        String password = (String) input.get("password");
        List<String> expectedProducts = (List<String>) input.get("products");

        ProductCataloguePage productCataloguePage =
                landingPage.loginApplication(email, password);

        System.out.println("Logged in successfully");

        productCataloguePage.addProductsToCart(expectedProducts);
        System.out.println("Products added to cart: " + expectedProducts);

        CartPage cartPage = productCataloguePage.goToCartPage();
        System.out.println("Navigated to cart page");

        expectedProducts.forEach(product ->
                Assert.assertTrue(
                        cartPage.verifyProductInCart(product),
                        product + " is not present in cart"
                )
        );

        CheckoutPage checkoutPage = cartPage.goToCheckout();
        System.out.println("Navigated to checkout page");

        checkoutPage.selectCountry("Indi");
        System.out.println("Country selected");

        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        System.out.println("Order submitted");

        String orderPlacedMessage = confirmationPage.getConfirmationMessage();

        Assert.assertTrue(
                orderPlacedMessage.equalsIgnoreCase("Thankyou for the order."),
                "Order confirmation message mismatch. Actual message: " + orderPlacedMessage
        );

        System.out.println("Order placed successfully.");
    }

    @DataProvider
    public Object[][] getData() {

        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("email", "karthik.sivakuma@gmail.com");
        map1.put("password", "Karthik@27");
        map1.put("products", List.of("ZARA COAT 3", "iphone 13 pro"));

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("email", "karthik.sivakuma@gmail.com");
        map2.put("password", "Karthik@27");
        map2.put("products", List.of("ZARA COAT 3"));

        return new Object[][]{
                {map1},
                {map2}
        };
    }
}