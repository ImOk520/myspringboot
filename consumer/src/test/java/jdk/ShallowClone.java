package jdk;

import lombok.Data;

/**
 * 浅拷贝实现：通过拷贝构造方法实现浅拷贝
 * Feng, Ge 2021/4/15 0015 15:02
 */
public class ShallowClone {
    public static void main(String[] args) {
        Age a = new Age(20);
        People p1 = new People(a, "ok");
        People p2 = new People(p1);
        System.out.println("修改前p1是" + p1);
        System.out.println("修改前p2是" + p2);
        //修改p1的各属性值，观察p2的各属性值是否跟随变化
        p1.setName("小傻瓜");
        a.setAge(99);
        System.out.println("修改后的p1是" + p1);
        System.out.println("修改后的p2是" + p2);
    }
}

@Data
class People {
    //两个属性值：分别代表值传递和引用传递
    private Age age;
    private String name;

    public People(Age age, String name) {
        this.age = age;
        this.name = name;
    }

    //拷贝构造方法
    public People(People p) {
        this.name = p.name;
        this.age = p.age;
    }
}

