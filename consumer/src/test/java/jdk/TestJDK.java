package jdk;

import cn.hutool.core.lang.Console;
import jdk.common.bean.Jim;
import jdk.common.bean.Person;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Feng, Ge 2021/6/28 0028 10:53
 */
public class TestJDK {

    @Test
    public void test1() {
        print("1");
        print("2", "3");
        print("4", "5", "6");
    }

    private void print(String... args) {
        for (int i = 0; i < args.length; i++) {
            Console.log(args[i]);
        }
    }

    ;

    @Test
    public void test2() {
        int i = 1;
        int j = i++;
        if ((i == (++j)) && ((i++) == j)) {
            i += j;
        }
        System.out.println("i = " + i);
    }

    @Test
    public void test3() {
        String str = "";
        for (int x = 0; x < 5; x++) {
            str += x;
        }
        System.out.println(str);
    }

    @Test
    public void test4() {
        int i1 = 10 % 2;
        int j1 = 10 / 3;
        boolean i = 10 % 2 == 1;
        boolean j = 10 / 3 == 0;
        Console.log("i1:{},j1:{}", i1, j1);
        Console.log("i:{},j:{}", i, j);
        // 短路与，第一个false，后面都是不会再判断
        boolean flag = 10 % 2 == 1 && 10 / 3 == 0 && 1 / 0 == 0;
        System.out.println(flag ? "aliyunedu" : "yootk");
    }

    @Test
    public void test5() {
        int sum = 0;
        int x = 10;
        while (x > 0) {
            sum += x;
        }
        System.out.println(sum);
    }

    @Test
    public void test6() {
        int num = 50;
        num = num++ * 2;
//        num = num * 2;
        System.out.println(num);
    }

    @Test
    public void test7() {
        int x=10;
        double y=20.2;
        long z=10L;
        String str=""+ x + y *z;
        System.out.println(str);
    }

    @Test
    public void test8() {
        Person jim = new Jim("Jim", 18);
        String args[] = new String[0];
        Person.main(args);
    }

    @Test
    public void test9() {
        String s = "abcd";
        System.out.println("s = " + s);
        Field valueField = null;
        try {
            valueField = String.class.getDeclaredField("value");
            valueField.setAccessible(true);

            char[] value = (char[]) valueField.get(s);

            value[3] = 'e';
            System.out.println("s = " + s);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
