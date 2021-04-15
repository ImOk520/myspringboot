package jdk;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * Feng, Ge 2021/4/15 0015 16:11
 */
@Data
class Age03 implements Serializable {
    //年龄类的成员变量（属性）
    private int age;
    //构造方法
    public Age03(int age) {
        this.age=age;
    }
}

