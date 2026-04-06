package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ConfirmationPage;
import pages.ProductCataloguePage;
import testComponents.BaseTest;

import java.util.List;

class SubmitOrderTest extends BaseTest {

    @Test
    public void submitOrderTest() {
        List<String> expectedProducts = List.of("ZARA COAT 3", "iphone 13 pro");

        ProductCataloguePage productCataloguePage =
                landingPage.loginApplication("karthik.sivakuma@gmail.com", "Karthik@27");

        productCataloguePage.addProductsToCart(expectedProducts);

        CartPage cartPage = productCataloguePage.goToCartPage();

        expectedProducts.forEach(product ->
                Assert.assertTrue(
                        cartPage.verifyProductInCart(product),
                        product + " is not present in cart"
                )
        );

        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("Indi");

        ConfirmationPage confirmationPage = checkoutPage.submitOrder();

        String orderPlacedMessage = confirmationPage.getConfirmationMessage();

        Assert.assertTrue(
                orderPlacedMessage.equalsIgnoreCase("Thankyou for the order."),
                "Order confirmation message mismatch. Actual message: " + orderPlacedMessage
        );

        System.out.println("Order placed successfully.");
    }
}