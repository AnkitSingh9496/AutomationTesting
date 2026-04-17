package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Driver;

public class baseTest {
    protected WebDriver instance;

    @BeforeMethod
    public void setup(){
        instance = Driver.initInstance();
        instance.get("https://saucedemo.com");
    }

    @AfterMethod
    public void quit(){
        if(instance!=null){
            instance.quit();
        }
    }
}
