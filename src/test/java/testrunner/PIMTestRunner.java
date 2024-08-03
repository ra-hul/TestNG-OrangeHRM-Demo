package testrunner;

import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PIMPage;
import setup.EmployeeModel;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class PIMTestRunner extends Setup {
    PIMPage pimPage;

    LoginPage loginPage;
    @BeforeTest(groups = "smoke")
    public void doLogin(){
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");
    }
    @Test(priority = 1, groups ="smoke")
    public void checkEmployeeList() throws InterruptedException {
        pimPage = new PIMPage(driver);
        pimPage.leftMenubar.get(1).click();
        Thread.sleep(5000);
        String messageActual= driver.findElements(By.className("oxd-text--span")).get(12).getText();
        System.out.println(messageActual);
        String messageExpected = "Records Found";


//        contains for string manipulation, cause we need to match the Records found.
        Assert.assertTrue(messageActual.contains(messageExpected));
    }
    @Test(priority = 2)
    public void addNewEmployee() throws IOException, ParseException {
        pimPage.button.get(2).click();
        driver.findElement(By.className("oxd-switch-input")).click();
        pimPage = new PIMPage(driver);

        Faker faker= new Faker();
        String firstName= faker.name().firstName();
        String lastName= faker.name().lastName();
        String username = faker.name().username();
        String password= "007Rahul@Paul!";


        EmployeeModel model= new EmployeeModel();
        model.setFirstName(firstName);
        model.setLastName(lastName);
        model.setUsername(username);
        model.setPassword(password);


        pimPage.createNewEmployee(model);

        WebElement headerTitleElm=driver.findElement(By.xpath("//h6[text()=\"Personal Details\"]"));
        System.out.println(headerTitleElm.getText());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        wait.until(ExpectedConditions.visibilityOf(headerTitleElm));
        String textTitle= headerTitleElm.getText();
        Assert.assertTrue(textTitle.contains("Personal Details"));

        Utils.saveUser(model);

    }

}
