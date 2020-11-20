package lambda;

import entity.A;
import entity.B;

import java.util.ArrayList;
import java.util.List;

/**
 * Feng, Ge 2020-11-09 15:43
 */
public class StreamAPI {

    public static List<String> getStringList(){
        List<String> list = new ArrayList<>();
        list.add("6");
        list.add("5");
        list.add("18");
        list.add("86");
        return list;
    }

    public static List<Integer> getIntegerList(){
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(8);
        list.add(8);
        return list;
    }

    public static List<B> getBList(){
        List<B> list = new ArrayList<>();
        list.add(new B("小米", 16));
        list.add(new B("小名", 3));
        list.add(new B("小6", 6));
        list.add(new B("看看", 9));
        list.add(new B("小蓝", 16));
        list.add(new B("小p", 3));
        list.add(new B("开开", 6));
        list.add(new B("好看", 9));
        return list;
    }

    public static List<B> getBNullList(){
        List<B> list = new ArrayList<>();
        list.add(new B("", 16));
        list.add(new B("", 3));
        list.add(new B("小6", 6));
        list.add(new B("", 9));
        list.add(new B("", 16));
        list.add(new B("", 3));
        list.add(new B("", 6));
        list.add(new B("", 9));
        return list;
    }
}
