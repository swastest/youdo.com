package youdo.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:properties/remote.properties")
public interface RemoteConfigInterface extends Config{
    String remoteUrl();
    String selenoidLogin();
    String selenoidPassword();
}
