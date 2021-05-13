package fengge.config.importAnnotation;

import fengge.DTO.CarDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ImportTestConfig {

    @Bean
    public CarDTO carDTO(){
        return new CarDTO(1, "qq");
    }
}
