package config;

/**
 * Список путей API @see
 */
public enum ApiPathEnum {
    BASE_URL("https://stellarburgers.nomoreparties.site"),
    LOGIN("/api/auth/login"),
    REGISTER("/api/auth/register"),
    USER("/api/auth/user");

    private final String title;

    ApiPathEnum(String path) {
        this.title = path;
    }

    public String getTitle() {
        return title;
    }
}