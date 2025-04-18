package learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

    Properties pro;

    //Below is the Constructor, it will help you to initialize variables and objects
    public ConfigDataProvider() {
        File src = new File("./Config/Config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);

            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Not able to load config file>>" + e.getMessage());
        }
    }

        //Method we are creating to read value from a Config file
        //You can create more methods like below
//        public String getDataFromConfig(String keyToSearch)
//        {
//            return pro.getProperty(keyToSearch);
//        }

        public String getBrowser()
        {
            return pro.getProperty("Browser");
        }

        public String getStagingURL()
        {
            return pro.getProperty("qaURL");
        }

    }
