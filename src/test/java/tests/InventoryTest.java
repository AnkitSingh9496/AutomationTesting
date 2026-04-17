package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryTest extends baseTest {

    @Test
    public void addProductToCart(){
        LoginPage login = new LoginPage(instance);
        login.Login(ConfigReader.getUsername(), ConfigReader.getPassword());
        InventoryPage inventory = new InventoryPage(instance);
        inventory.addProducts();

        Assert.assertEquals(inventory.getProductCount(),2);
    }

    @Test
    public void sortLtoH(){
        LoginPage login = new LoginPage(instance);
        login.Login("standard_user","secret_sauce");

        InventoryPage inventory = new InventoryPage(instance);
        inventory.sortBy("Price (low to high)");

        List<Double> actual = inventory.getPrice();
        List<Double> sorted = new ArrayList<>(actual);
        Collections.sort(sorted);

        Assert.assertEquals(actual,sorted);
    }
}