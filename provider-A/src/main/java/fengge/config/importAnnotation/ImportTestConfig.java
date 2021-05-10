package fengge.config.importAnnotation;

import fengge.DTO.CarDTO;
import fengge.DTO.PersonDTO;
import fengge.config.conditional.MyCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ImportTestConfig {

    @Bean("GEELY")
    public CarDTO geelyCar(){
        return new CarDTO(2,"GEELY");
    }

    @Bean("CHANGAN")
    public CarDTO changAnCar(){
        return new CarDTO(3,"CHANGAN");
    }

}
