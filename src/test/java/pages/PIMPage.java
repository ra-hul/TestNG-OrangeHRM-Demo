package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.EmployeeModel;

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

    public void createNewEmployee(EmployeeModel model){
        txtField.get(1).sendKeys(model.getFirstName());
        txtField.get(3).sendKeys(model.getLastName());
        txtField.get(5).sendKeys(model.getUsername());
        txtField.get(6).sendKeys(model.getPassword());
        txtField.get(7).sendKeys(model.getPassword());
        button.get(1).click();
    }
}
