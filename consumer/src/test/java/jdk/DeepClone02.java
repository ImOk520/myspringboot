package jdk;

import lombok.Data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Feng, Ge 2021/4/15 0015 16:11
 */
public class DeepClone02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException  {
        Age03 a=new Age03(20);
        Student03 stu1=new Student03("ok",a,175);
        //通过序列化方法实现深拷贝
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(stu1);
        oos.flush();
        ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        Student03 stu2=(Student03)ois.readObject();
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());
        System.out.println();
        //尝试修改stu1中的各属性，观察stu2的属性有没有变化
        stu1.setName("大傻子");
        //改变age这个引用类型的成员变量的值
        a.setAge(99);
        stu1.setLength(216);
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());
    }

}

@Data
class Student03 implements Serializable {
    private String name;
    private Age03 aage;
    private int length;
    //构造方法,其中一个参数为另一个类的对象
    public Student03(String name,Age03 a,int length) {
        this.name=name;
        this.aage=a;
        this.length=length;
    }
}

