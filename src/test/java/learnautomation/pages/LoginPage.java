package learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver ldriver)
            //WebDriver as a reference.
            //In constructor, we have to pass this, otherwise it will not be identified the drivers
            //'ldriver' will come from the main testcase, whatever the driver reference passes from the test case it will store into this driver.
    {
        this.driver = ldriver;
    }

    @FindBy(name = "email") WebElement uname;

    @FindBy(name = "password") WebElement pass;

    @FindBy(xpath = "//input[@value='Log in']") WebElement loginButton;

    public void loginToRahulShetty(String usernameApplication, String passwordApplication) throws InterruptedException {

        Thread.sleep(2000);

        uname.sendKeys(usernameApplication);
        pass.sendKeys(passwordApplication);
        loginButton.click();
    }
}
