package utility;

public enum ReadLogin {
    STANDARD_USER("standardUser"), PASSWORD("password");

    private String key;

    ReadLogin(String key) {
        this.key = key;
    }

    public String convertToString() {
        return key.toString();
    }
}
