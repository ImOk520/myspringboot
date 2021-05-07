package fengge.config.componentScan;

import fengge.DTO.CarDTO;
import fengge.DTO.PersonDTO;
import fengge.dao.DeptDaoClass_Component;
import org.springframework.context.annotation.Bean;
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
