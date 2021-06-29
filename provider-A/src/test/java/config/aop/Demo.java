package config.aop;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * Feng, Ge 2021/6/25 0025 10:47
 */
@Data
public class Demo {

    @Value("狗蛋") // 注入静态值
    private String name;

    private Integer index;
}
