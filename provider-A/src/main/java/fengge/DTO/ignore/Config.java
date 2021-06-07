package fengge.DTO.ignore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feng, Ge 2021/6/7 0007 10:10
 */
@Configuration
public class Config {

    @Bean
    public Person getPerson(){
        return new Person();
    }

//    @Bean
//    public Admin getAdmin(){
//        return new Admin();
//    }
//
//    @Bean
//    public Role getRole(){
//        return new Role();
//    }
//
//    @Bean
//    public User getUser(){
//        return new User();
//    }
}
