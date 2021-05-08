package fengge.config.conditional;

import fengge.DTO.CarDTO;
import fengge.DTO.PersonDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class ConditionalTestConfig {

    @Bean("GEELY")
    @Conditional({MyCondition.class})
    public CarDTO geelyCar(){
        return new CarDTO(2,"GEELY");
    }

    @Bean("CHANGAN")
    @Conditional({MyCondition.class})
    public CarDTO changAnCar(){
        return new CarDTO(3,"CHANGAN");
    }

    @Bean("BMW")
    @Conditional({MyCondition.class})
    public CarDTO foreignCar(){
        return new CarDTO(1,"BMW");
    }

    @Bean("ppp")
    @Conditional({MyCondition.class})
    public PersonDTO personDTO(){
        return new PersonDTO(1,"OK");
    }
}
