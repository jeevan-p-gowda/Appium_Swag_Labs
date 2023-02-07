package utility;

import java.util.Properties;

public class ReadConfig {
    private Properties pro;
    private PropertyLoader pl;

    public ReadConfig() {
        this.pro = new Properties();
        this.pl = new PropertyLoader();
        pl.loadPropertyFile("./properties/Configuration.properties");
    }

    public String appPackage_key() {
        String appPackage_key = pro.getProperty("appPackage_key");
        return appPackage_key;
    }

    public String appActivity_key() {
        String appActivity_key = pro.getProperty("appActivity_key");
        return appActivity_key;
    }

    public String appPackage_value() {
        String appPackage_value = pro.getProperty("appPackage_value");
        return appPackage_value;
    }

    public String appActivity_value() {
        String appActivity_value = pro.getProperty("appActivity_value");
        return appActivity_value;
    }

    public String url() {
        String url = pro.getProperty("url");
        return url;
    }
}

