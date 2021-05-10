package fengge.config.importAnnotation;

import fengge.DTO.CarDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({A.class, B.class, MyImportSelector.class})
public class ImportTestConfig02 {

    @Bean("GEELY")
    public CarDTO geelyCar(){
        return new CarDTO(2,"GEELY");
    }

    @Bean("CHANGAN")
    public CarDTO changAnCar(){
        return new CarDTO(3,"CHANGAN");
    }

}
