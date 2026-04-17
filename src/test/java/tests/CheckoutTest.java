package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;

public class CheckoutTest extends baseTest {
    @Test
    public void checkoutFlow(){
        LoginPage login = new LoginPage(instance);
        login.Login(ConfigReader.getUsername(), ConfigReader.getPassword());
        InventoryPage inventory = new InventoryPage(instance);
        inventory.addProducts();
        CartPage cart = new CartPage(instance);
        cart.openCar();
        cart.checkOut();
        CheckoutPage checkout = new CheckoutPage(instance);
        checkout.enterDetails("Aryaveer","Singh","6531");
        checkout.continueCheckout();
        checkout.finishCheckout();
        Assert.assertTrue(checkout.getConfirmationMsg("Thank you for your order!"));
    }
}
