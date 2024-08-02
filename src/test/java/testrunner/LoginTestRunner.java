package testrunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import setup.Setup;

public class LoginTestRunner extends Setup {

    LoginPage loginPage;

    @Test(priority = 1,description = "Admin cannot login with invalid creds")
    public void doLoginIfWrongCreds(){
        loginPage = new LoginPage(driver);
        loginPage.doLogin("wrongAdmin", "admin123456");
        WebElement alertTextElem = driver.findElement(By.className("oxd-alert-content-text"));
        Assert.assertEquals(alertTextElem.getText(),"Invalid Credentials");
    }

    @Test(priority = 2, description = "Admin can login with valid creds")
    public void doLogin(){
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");
        Assert.assertTrue(loginPage.btnProfileImage.isDisplayed());
    }

    @Test(priority = 3,description = "Admin can logout by clicking on logout button")
    public void doLogout(){
        loginPage = new LoginPage(driver);
        loginPage.doLogout();
        WebElement forgotPasswordLinkElem= driver.findElement(By.className("orangehrm-login-forgot-header"));

        Assert.assertTrue(forgotPasswordLinkElem.isDisplayed());
    }


}
