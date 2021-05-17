package fengge.config.value;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Value 注解
 * 1、注入静态值
 * 2、SpEL表达式：#{}
 * 3、${},获取配置文件中的值（或者运行环境中的值）
 */
@Data
public class Person01 {

    @Value("狗蛋") // 注入静态值
    private String name;

    @Value("#{100-90}") // SpEL表达式
    private Integer age;

    @Value("${person.sex}") // 获取配置文件中的值
    private String sex;
}
