package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver instance;
    By username = By.id("user-name");
    By password = By.id("password");
    By logBtn = By.xpath("//*[@id=\"login-button\"]");
    By errorMessage = By.xpath("//h3[@data-test='error']");


    public  LoginPage(WebDriver instance){
        this.instance=instance;
    }
    public void Login(String user, String pass){
        instance.findElement(username).sendKeys(user);
        instance.findElement(password).sendKeys(pass);
        instance.findElement(logBtn).click();
    }
    public String getErrorMessage(){
        return instance.findElement(errorMessage).getText();

    }
}
