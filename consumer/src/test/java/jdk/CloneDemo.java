package jdk;

/**
 * Cloneable接口使得对象具有拷贝功能
 * 拷贝后改变原对象的值，看拷贝生成的新对象是否改变，若不改变就是深拷贝
 * 这里是深拷贝
 * Feng, Ge，2021年4月15日14:57:12
 */
public class CloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A("A", 1);
        A b = (A) a.clone();
        System.out.println(a);
        System.out.println(a.getName());
        System.out.println(a.getNum());
        System.out.println(b);
        System.out.println(b.getName());
        System.out.println(b.getNum());
        System.out.println("===================================");

        // 修改A的值，看B的值是否改变
        a.setName("OK");
        System.out.println(a);
        System.out.println(a.getName());
        System.out.println(a.getNum());
        System.out.println(b);
        System.out.println(b.getName());
        System.out.println(b.getNum());
    }
}

class A implements Cloneable{
    private String name;
    private int num;
    public A(String name, int num) {
        this.name = name;
        this.num = num;
    }
    public String getName() {
        return name;
    }
    public int getNum() {
        return num;
    }

    public void setName(String name) {
         this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
