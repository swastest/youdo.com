package youdo.config;

import org.aeonbits.owner.Config;
@Config.Sources("classpath:properties/link.properties")
public interface LinkConfig extends Config {
    String url();
}
