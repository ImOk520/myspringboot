package feng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Feng, Ge 2020-10-08 22:05
 */
@SpringBootApplication
//@EnableEurekaClient
public class ProviderB {
    public static void main(String[] args) {
        SpringApplication.run(ProviderB.class, args);
    }
}
