package jdk;

import lombok.Data;

/**
 * 深拷贝实现：通过重写clone方法来实现深拷贝
 * 原始的clone（）方法对于引用类型是浅拷贝，因此需要重写原始clone（）方法才能实现深拷贝
 * Feng, Ge 2021/4/15 0015 15:53
 */
public class DeepClone {
    public static void main(String[] args) {
        Age02 a=new Age02(20);
        Student02 stu1=new Student02("ok",a,175);
        //通过调用重写后的clone方法进行浅拷贝
        Student02 stu2=(Student02)stu1.clone();
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());
        System.out.println();
        //尝试修改stu1中的各属性，观察stu2的属性有没有变化
        stu1.setName("大傻子");
        //改变age这个引用类型的成员变量的值
        a.setAge(99);
        //stu1.setaAge(new Age(99));    使用这种方式修改age属性值的话，stu2是不会跟着改变的。因为创建了一个新的Age类对象而不是改变原对象的实例值
        stu1.setLength(216);
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());
    }

}

@Data
class Student02 implements Cloneable{
    private String name;
    private Age02 aage;
    private int length;
    //构造方法,其中一个参数为另一个类的对象
    public Student02(String name,Age02 a,int length) {
        this.name=name;
        this.aage=a;
        this.length=length;
    }

    //重写Object类的clone方法
    public Object clone() {
        Object obj=null;
        //调用Object类的clone方法——浅拷贝
        try {
            obj= super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //调用Age类的clone方法进行深拷贝
        //先将obj转化为学生类实例
        Student02 stu=(Student02)obj;
        //学生类实例的Age对象属性，调用其clone方法进行拷贝
        stu.aage=(Age02)stu.getAage().clones();
        return obj;
    }
}


