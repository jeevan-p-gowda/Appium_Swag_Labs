package utility;

public enum ReadConfigKeys {
    APPPACKAGE_KEY("appPackage_Key"),APPPACKAGE_VALUE("appPackage_Value"),APPACTIVITY_KEY("appActivity_key"),
    APPACTIVITY_VALUE("appActivity_value"),URL("url");
    private String key;

    private ReadConfigKeys(String key) {
        this.key = key;
    }

    public String convertToString() {
        return key.toString();
    }
}

