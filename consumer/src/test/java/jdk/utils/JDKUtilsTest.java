package jdk.utils;

import cn.hutool.core.lang.Console;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Feng, Ge 2021/5/27 0027 15:13
 */
@SpringBootTest
public class JDKUtilsTest {

    /**
     * List集合拼接成以逗号分隔的字符串
     * =====> 把list集合拼接成以逗号分隔的字符串 a,b,c
     * =====> join（）好用的很
     */
    @Test
    public void test(){
        List<String> list = Arrays.asList("a", "b", "c");
        // 第一种方法，可以用stream流
        String result = list.stream().collect(Collectors.joining(","));
        Console.log(result); // 输出 a,b,c
        // 第二种方法，其实String也有join方法可以实现这个功能
        String result1 = String.join(",", list);
        Console.log(result1); // 输出 a,b,c
    }

    /**
     * 两个List集合取交集
     *
     */
    @Test
    public void test1(){
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("d");
        boolean b = list1.retainAll(list2);
        Console.log("集合取交集:{}",list1); // 输出[a, b]
    }

    /**
     * addAll方法
     *
     */
    @Test
    public void test2(){
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("d");
        list1.addAll(list2);
        Console.log("集合集:{}",list1); // 输出[a, b, c, a, b, d]
    }

}
