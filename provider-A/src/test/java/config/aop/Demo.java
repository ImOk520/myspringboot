package config.aop;

import lombok.AllArgsConstructor;

/**
 * Feng, Ge 2021/6/25 0025 10:47
 */
public class Demo {

    private String name;

    private Integer index;

    public Demo(String name, Integer index) {
        this.name = name;
        this.index = index;
    }

    public Demo(String name) {
        this.name = name;
    }
}
