package learnautomation.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    //We should have the below methods in this class while creating Framework
    //Screenshots, Alerts, Frames, Windows, Sync Issues, Custom library for JavaScript Executor

    //If you create method static, then you can call method directly.
    //Otherwise, you need to create an object of Helper class in Base Class; then by using an object you can call these methods
    public static String captureScreenshot(WebDriver driver)
    {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //To enhance line 30, I did below line
        String screenshotPath = System.getProperty("user.dir") + "/Screenshots/Rahul Shetty_" +getCurrentDateTime()+".png";

        try {
            //For not revised the same file of SS with Login so we will create one method it will show time stamp
            //FileHandler.copy(src, new File("./Screenshots/Login.png"));

            //Below line will create SS with time and date
           // FileHandler.copy(src, new File("./Screenshots/RahulShetty_"+ getCurrentDateTime() + ".png"));

            //To enhancing the above line
            FileHandler.copy(src, new File(screenshotPath));

            System.out.println("Screenshot captured");
        } catch (IOException e) {
            System.out.println("Unable to capture screenshot" + e.getMessage());
        }
        return screenshotPath;
    }

    public static String getCurrentDateTime()
    {
        DateFormat customFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");

        Date currentDate = new Date();
        return customFormat.format(currentDate);
    }


    public void handleFrames()
    {

    }
}
