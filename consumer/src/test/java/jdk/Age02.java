package jdk;

import lombok.Data;

/**
 * Feng, Ge 2021/4/15 0015 15:55
 */
@Data
class Age02 implements Cloneable{
    private int age;
    public Age02(int age) {
        this.age=age;
    }

    //重写Object的clone方法
    public Object clones() {
        Object obj=null;
        try {
            obj=super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}