package tests.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:real.properties"
})
public interface RealDeviceConfig extends Config {

    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("platformVersion")
    String platformVersion();
}
