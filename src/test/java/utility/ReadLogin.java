package utility;

public enum ReadLogin {
    STANDAR_USER("standardUser"), PASSWORD("password");

    private String keys;

    ReadLogin(String keys) {
        this.keys = keys;
    }

    public String convertToString() {
        return keys.toString();
    }
}
