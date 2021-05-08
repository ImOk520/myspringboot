package fengge.config.conditional;

import fengge.DTO.CarDTO;
import fengge.DTO.PersonDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalTestConfig02 {

    @Bean("GEELY")
    @Conditional({MadeInChinaCondition.class})
    public CarDTO geelyCar(){
        return new CarDTO(2,"GEELY");
    }

    @Bean("CHANGAN")
    @Conditional({MadeInChinaCondition.class})
    public CarDTO changAnCar(){
        return new CarDTO(3,"CHANGAN");
    }

    @Bean("BMW")
    @Conditional({MadeInChinaCondition.class})
    public CarDTO foreignCar(){
        return new CarDTO(1,"BMW");
    }

    @Bean("ppp")
    @Conditional({MadeInChinaCondition.class})
    public PersonDTO personDTO(){
        return new PersonDTO(1,"OK");
    }
}
