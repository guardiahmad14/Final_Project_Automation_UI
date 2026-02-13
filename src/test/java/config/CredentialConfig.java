package config;

public class CredentialConfig {
    public static final String EMAIL = EnvConfig.get("EMAIL");
    public static final String PASSWORD = EnvConfig.get("PASSWORD");

    static {
        if (EMAIL.isBlank() || PASSWORD.isBlank()) {
            throw new IllegalStateException(
                    "Missing required auth environment variables: " +
                            "EMAIL, PASSWORD"
            );
        }
    }

    private CredentialConfig() {
    }
}
