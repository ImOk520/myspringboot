package config.conditional;

import fengge.DTO.CarDTO;
import fengge.DTO.PersonDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalTestConfig02 {

    @Conditional({MadeInChinaCondition.class})
    @Bean("GEELY")
    public CarDTO geelyCar(){
        return new CarDTO(2,"GEELY");
    }

    @Conditional({MadeInChinaCondition.class})
    @Bean("CHANGAN")
    public CarDTO changAnCar(){
        return new CarDTO(3,"CHANGAN");
    }

    @Conditional({ForeignCondition.class})
    @Bean("BMW")
    public CarDTO foreignCar(){
        return new CarDTO(1,"BMW");
    }

    @Conditional({MadeInChinaCondition.class})
    @Bean("PERSON")
    public PersonDTO personDTO(){
        return new PersonDTO(1,"OK");
    }
}
