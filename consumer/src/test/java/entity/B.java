package entity;

import lombok.Data;

/**
 * Feng, Ge 2020-10-20 17:12
 */
@Data
public class B {

    private String name;

    private Integer age;

    public B(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
