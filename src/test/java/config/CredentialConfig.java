package config;
import io.github.cdimascio.dotenv.Dotenv;

public class CredentialConfig {
        public static final String EMAIL = System.getenv("EMAIL");
        public static final String PASSWORD = System.getenv("PASSWORD");
    }
//    public static final String EMAIL = EnvConfig.get("EMAIL");
//    public static final String PASSWORD = EnvConfig.get("PASSWORD");
//    public static final String COMPANY_ID = EnvConfig.get("COMPANY_ID");
//}
