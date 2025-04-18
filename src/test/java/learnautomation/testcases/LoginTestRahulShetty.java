package learnautomation.testcases;

import learnautomation.pages.BaseClass;
import learnautomation.pages.LoginPage;
import learnautomation.utilities.ExcelDataProvider;
import learnautomation.utilities.Helper;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class LoginTestRahulShetty extends BaseClass {

    @Test(priority = 1)
    public void loginApp() throws InterruptedException, FileNotFoundException {

        //logger will have all responsible for all the login test cases
        logger = report.createTest("Login to Rahul Shetty Site");

        //ExcelDataProvider excel = new ExcelDataProvider();

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        //Below we are giving information of Test Steps
        logger.info("Starting Application");

        //Here we did Abstraction: - Showing the essential features and hiding the background details
        //loginPage.loginToRahulShetty("vaidyanupur.91@gmail.com","Nupur@1391");

        //While accessing the Excel sheet
        loginPage.loginToRahulShetty(excel.getStringData("Login",0,0),excel.getStringData("Login",0,1));

        logger.pass("Login Done Successfully");

        //If the test case gets fail it will not capture the screenshot, but if it is pass it will capture
        Helper.captureScreenshot(driver);
    }

}
