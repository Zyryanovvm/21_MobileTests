package tests.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:emulation.properties"
})
public interface EmulationConfig extends Config {

    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("platformVersion")
    String platformVersion();
}
