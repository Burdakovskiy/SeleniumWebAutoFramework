package framework.core.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties",
        "system:properties"
})


public interface TestConfig extends Config {

    @Key("baseUrl")
    String baseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("headless")
    @DefaultValue("false")
    boolean headless();

    @Key("windowWidth")
    @DefaultValue("1400")
    int windowWidth();

    @Key("windowHeight")
    @DefaultValue("900")
    int windowHeight();

    @Key("timeoutSeconds")
    @DefaultValue("10")
    int timeoutSeconds();
}
