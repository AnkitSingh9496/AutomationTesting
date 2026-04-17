package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver instance;

    By cartIcon = By.className("shopping_cart_link");
    By checkoutBtn = By.id("checkout");
    public CartPage(WebDriver instance){
        this.instance=instance;
    }
    public void openCar(){
        instance.findElement(cartIcon).click();
    }
    public void checkOut(){
        instance.findElement(checkoutBtn).click();
        System.out.println("Clicked to checkout");
    }
}
