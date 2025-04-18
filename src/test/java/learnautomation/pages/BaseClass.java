package learnautomation.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import learnautomation.utilities.BrowserFactory;
import learnautomation.utilities.ConfigDataProvider;
import learnautomation.utilities.ExcelDataProvider;
import learnautomation.utilities.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseClass {

    public WebDriver driver;
    public ExcelDataProvider excel;
    public ConfigDataProvider config;
    public ExtentReports report;
    public ExtentTest logger;

    @BeforeSuite
    public void setUpSuite()
    {
        //The Below line is for generating logs, and it will show you in console as well
        Reporter.log("Setting up reports and Test is getting ready", true);

        excel = new ExcelDataProvider();
        config = new ConfigDataProvider();

        //'user.dir' will give you a current working directory, it will give you a path of the reports
        ExtentSparkReporter extent = new ExtentSparkReporter (new File(System.getProperty("user.dir")+ "/Reports/RahulShetty_" +Helper.getCurrentDateTime()+".html"));
        //We created object of Extent Report
        report = new ExtentReports();
        //Attaching the report
        report.attachReporter(extent);

        //The Below line is for generating logs, and it will show you in console as well
        Reporter.log("Setting Done- Test can be started", true);

    }
    @BeforeClass
    public void setup() {
        //The Below line is for generating logs, and it will show you in console as well
        Reporter.log("Trying to start Browser and Getting Application ready", true);

       // driver = BrowserFactory.startApplication(driver,"Chrome", "https://sso.teachable.com/secure/9521/identity/login/password?force=true");

        //Use below when we call data from a config file
        driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());

        //The Below line is for generating logs, and it will show you in console as well
        Reporter.log("Browser and Application is up and running", true);
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitBrowser(driver);
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result)
    {
        //The Below line is for generating logs, and it will show you in console as well
        Reporter.log("Test is about to End", true);


        //ITestResult interface will do as soon as test will complete the 'result' variable will have all the information
        if(result.getStatus() == ITestResult.FAILURE)
        {
            //Below line take screenshot if your test pass or fail, but line 82 will take SS when test fail and attach to report
            //Helper.captureScreenshot(driver);

            //To capture SS when test gets fail and want the SS in a report, then do below
            logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
        }
        else if(result.getStatus() == ITestResult.SKIP)
        {
            logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
        }

        //Below will keep adding the reports of the test into a single report
        report.flush();

        //The Below line is for generating logs, and it will show you in console as well
        Reporter.log("Test completed >> Reports Generated", true);

    }
}
