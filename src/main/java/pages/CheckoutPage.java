package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver instance;
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By pinCod = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By confirmationMsg = By.className("complete-header");

    public CheckoutPage(WebDriver instance){
        this.instance=instance;
    }
    public void enterDetails(String fName, String lName,String pCode){
        instance.findElement(firstName).sendKeys(fName);
        instance.findElement(lastName).sendKeys(lName);
        instance.findElement(pinCod).sendKeys(pCode);
    }
    public void continueCheckout(){
        instance.findElement(continueBtn).click();
    }
    public void finishCheckout(){
        instance.findElement(finishBtn).click();
    }
    public boolean getConfirmationMsg(String expectedText){
        String actualText = instance.findElement(confirmationMsg).getText().trim();
        return actualText.equalsIgnoreCase(expectedText.trim());
    }
}
