package fengge.config.conditional;

import fengge.DTO.CarDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConditionalTestConfig01 {

    @Bean("BMW")
    @Conditional({MadeInChinaCondition.class})
    public CarDTO foreignCar(){
        return new CarDTO(1,"BMW");
    }

    @Bean("GEELY")
    @Conditional({MadeInChinaCondition.class})
    public CarDTO madeInChinaCar(){
        return new CarDTO(2,"GEELY");
    }
}
