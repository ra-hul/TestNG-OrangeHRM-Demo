package testrunner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.LoginPage;
import setup.Setup;

import java.io.IOException;

import static utils.Utils.readJSONData;

public class UserLoginTestRunner extends Setup {
@Test(priority = 1, testName = "user login", description = "user can login with valid creds")
    public void userLogin() throws IOException, ParseException {
        LoginPage loginPage = new LoginPage(driver);
        JSONArray empArray = readJSONData();
        JSONObject empObject= (JSONObject) empArray.get(empArray.size()-1);

        String username = empObject.get("username").toString();
        String password = empObject.get("password").toString();
        loginPage.doLogin(username,password);


    }


}
