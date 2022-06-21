package tests.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:user.properties"
})
public interface UserConfig extends Config {

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
