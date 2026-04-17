package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;


public class LoginTest extends baseTest {
    @Test
    public void validLogin(){
        LoginPage login = new LoginPage(instance);
        login.Login(ConfigReader.getUsername(), ConfigReader.getPassword());
        InventoryPage inventory = new InventoryPage(instance);
        Assert.assertTrue(inventory.isLoaded(),"Inventory Page not loaded");
    }
    @Test
    public void invalidLogin(){
        LoginPage login = new LoginPage(instance);
        login.Login(ConfigReader.getLockedUser(), ConfigReader.getPassword());
        String error = login.getErrorMessage();
        Assert.assertTrue(error.contains("locked out"));
    }
    @DataProvider(name = "loginData")
    public Object[][] loginData(){
        return new Object[][]{
                {ConfigReader.getUsername(), ConfigReader.getPassword()},
                {ConfigReader.getLockedUser(), ConfigReader.getPassword()}
        };
    }
    @Test(dataProvider = "loginData")
    public void LogInTest(String user, String pass){
        LoginPage loginTest = new LoginPage(instance);
        loginTest.Login(user,pass);
        if(user.equals("standard_user")){
            Assert.assertTrue(instance.getCurrentUrl().contains("inventory"));
        }else{
            Assert.assertTrue(loginTest.getErrorMessage().length()>0);
        }
    }

}
