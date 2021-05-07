package fengge.config.componentScan;

import fengge.DTO.CarDTO;
import fengge.DTO.PersonDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;


@Configuration
@ComponentScan(value = "fengge.dao", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
})
public class TestConfig02 {

}
