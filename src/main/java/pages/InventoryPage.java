package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage {
    WebDriver instance;

    By productPrice = By.className("inventory_item_price");
    By sortDropdown = By.className("product_sort_container");

    By addToCartButtons = By.xpath("//button[contains(text(),'Add to cart')]");

    By cartBadge = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver){
        this.instance = driver;
    }

    public boolean isLoaded(){
        return instance.getCurrentUrl().contains("inventory");
    }

    public void sortBy(String option){
        Select select = new Select(instance.findElement(sortDropdown));
        select.selectByVisibleText(option);
    }

    public void addProducts(){
        List<WebElement> buttons = instance.findElements(addToCartButtons);

        if(buttons.size() >= 2){
            buttons.get(0).click();
            buttons.get(1).click();
        }
    }

    public int getProductCount(){
        try {
            return Integer.parseInt(instance.findElement(cartBadge).getText());
        } catch (Exception e){
            return 0;
        }
    }

    public List<Double> getPrice(){
        return instance.findElements(productPrice)
                .stream()
                .map(e -> Double.parseDouble(e.getText().replace("$","")))
                .collect(Collectors.toList());
    }
}