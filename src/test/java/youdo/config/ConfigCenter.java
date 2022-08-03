package youdo.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigCenter {
    public static LinkConfig configLink = ConfigFactory.create(LinkConfig.class, System.getProperties());
    public static RemoteConfigInterface configRemote = ConfigFactory.create(RemoteConfigInterface.class, System.getProperties());
    public static TestDataConfig configTestData = ConfigFactory.create(TestDataConfig.class, System.getProperties());
}
