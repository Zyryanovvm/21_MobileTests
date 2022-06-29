package tests.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("urlRemotePhone")
    String urlRemotePhone();

    @Key("phone")
    String phone();

    @Key("modelPhone")
    String modelPhone();
}
