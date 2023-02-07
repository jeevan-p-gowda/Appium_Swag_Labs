package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyLoader {
   private Properties po;

    public void loadPropertyFile(String propertyFilePath) {
        File src = new File(propertyFilePath);
        try {
            FileInputStream fis = new FileInputStream(src);
            po = new Properties();
            po.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is" + e.getMessage());
        }
    }
}
