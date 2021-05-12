package fengge.config.importAnnotation;

import fengge.DTO.CarDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({A.class, B.class, MyImportSelector.class, MyRegistry.class})
public class ImportTestConfig03 {

}
