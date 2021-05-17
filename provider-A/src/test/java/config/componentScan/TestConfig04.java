package config.componentScan;

import fengge.dao.DeptDaoClass_Component;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(value = "fengge.dao", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {DeptDaoClass_Component.class})},
        useDefaultFilters = false
)
public class TestConfig04 {

}
