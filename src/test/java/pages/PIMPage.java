package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMPage {

    @FindBy (className = "oxd-main-menu-item--name" )
   public List<WebElement> leftMenubar;
    @FindBy(className = "oxd-button")
   public List<WebElement> button;
    @FindBy(className = "oxd-input")
   public List<WebElement> txtField;


    public PIMPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void createNewEmployee(String firstName, String lastName, String username,String password){
        txtField.get(1).sendKeys(firstName);
        txtField.get(3).sendKeys(lastName);
        txtField.get(5).sendKeys(username);
        txtField.get(6).sendKeys(password);
        txtField.get(7).sendKeys(password);
        button.get(1).click();
    }
}
