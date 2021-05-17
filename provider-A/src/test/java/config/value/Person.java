package config.value;

import cn.hutool.core.lang.Console;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Feng, Ge 2021/5/12 0012 18:08
 */
@Data
public class Person {

    private String name;

    private Integer age;

    private String sex;
}
