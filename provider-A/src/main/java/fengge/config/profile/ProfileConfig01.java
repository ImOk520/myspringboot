package fengge.config.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Feng, Ge 2021/5/18 0018 19:09
 */
@Configuration
public class ProfileConfig01 {

    @Profile("dev")
    @Bean
    public SomeConfig someConfigDev(){
        SomeConfig someConfig = new SomeConfig();
        someConfig.setUrl("http://1");
        someConfig.setPort("666");
        return someConfig;
    }

    @Profile("test")
    @Bean
    public SomeConfig someConfigTest(){
        SomeConfig someConfig = new SomeConfig();
        someConfig.setUrl("http://2");
        someConfig.setPort("667");
        return someConfig;
    }

    @Profile("prod")
    @Bean
    public SomeConfig someConfigProd(){
        SomeConfig someConfig = new SomeConfig();
        someConfig.setUrl("http://3");
        someConfig.setPort("668");
        return someConfig;
    }
}
