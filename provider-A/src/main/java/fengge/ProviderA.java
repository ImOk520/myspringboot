package fengge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Feng, Ge 2020-10-08 22:05
 */
@EnableEurekaClient
@SpringBootApplication
public class ProviderA {
    public static void main(String[] args) {
        SpringApplication.run(ProviderA.class, args);
    }

//    @Bean
//    public PlatformTransactionManager transactionManager(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
