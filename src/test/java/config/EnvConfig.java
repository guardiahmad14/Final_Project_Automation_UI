package config;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {

    private static final Dotenv dotenv = Dotenv.load();

    public static String get(String key) {
        return dotenv.get(key);
    }

    public static final String BASE_URL = get("BASE_URL");
    public static final String IS_DEBUG = get("DEBUG");
}
