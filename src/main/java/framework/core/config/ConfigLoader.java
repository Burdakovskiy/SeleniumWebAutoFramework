package framework.core.config;

import org.aeonbits.owner.ConfigFactory;

public final class ConfigLoader {
    private static final TestConfig CONFIG = ConfigFactory.create(TestConfig.class);

    private ConfigLoader() {}

    public static TestConfig config() {
        return CONFIG;
    }
}
