package jdk.common.bean;

/**
 * Feng, Ge 2021/6/28 0028 15:51
 */
public class Person {

    private String name;

    private Integer age;

    public String like;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        System.out.println("我是父类中的main方法！");
    }
}
