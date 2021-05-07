package fengge.config.componentScan;

import fengge.DTO.CarDTO;
import fengge.DTO.PersonDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;


@Configuration
@ComponentScans(value = {
        @ComponentScan(value = "fengge.dao", includeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyFilterType.class})},
                useDefaultFilters = false
        ),
        @ComponentScan(value = "fengge.dao", includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})},
                useDefaultFilters = false
        )
})
public class TestConfig06 {

}
