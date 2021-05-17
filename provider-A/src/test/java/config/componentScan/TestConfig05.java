package config.componentScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(value = "fengge.dao", includeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyFilterType.class})},
        useDefaultFilters = false
)
public class TestConfig05 {

}
