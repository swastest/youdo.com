package youdo.config;

import org.aeonbits.owner.Config;
@Config.Sources("classpath:properties/testData.properties")
public interface TestDataConfig extends Config {
    String loginEmail();
    String password();
}
