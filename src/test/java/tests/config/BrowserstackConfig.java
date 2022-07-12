package tests.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("urlApp")
    String urlApp();

    @Key("deviceName")
    String deviceName();

    @Key("androidVersion")
    String androidVersion();
}
