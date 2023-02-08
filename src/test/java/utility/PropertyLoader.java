package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
   private Properties pro;
   private FileInputStream fis;

    public void loadPropertyFile(String propertyFilePath) throws IOException {
            fis = new FileInputStream(propertyFilePath);
            pro = new Properties();
            pro.load(fis);
    }
    public String getDataFromPropertyFile(String key) {
        String value=pro.getProperty(key).trim();
        return value;
    }
    public void closePropertyFile() throws IOException {
        fis.close();
    }
}
