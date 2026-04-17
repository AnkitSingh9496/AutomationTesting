package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfigReader {

    private static final Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    public static String getUsername() {
        return dotenv.get("SAUCE_USERNAME");
    }

    public static String getPassword() {
        return dotenv.get("SAUCE_PASSWORD");
    }

    public static String getLockedUser() {
        return dotenv.get("LOCKED_USER");
    }
}