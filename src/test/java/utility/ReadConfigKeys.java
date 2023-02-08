package utility;

public enum ReadConfigKeys {
    APPPACKAGE_KEY("appPackage_Key"),APPPACKAGE_VALUE("appPackage_Value"),APPACTIVITY_KEY("appActivity_key"),
    APPACTIVITY_VALUE("appActivity_value"),URL("url");
    private String keys;

    private ReadConfigKeys(String keys) {
        this.keys = keys;
    }

    public String convertToString() {
        return keys.toString();
    }
}

