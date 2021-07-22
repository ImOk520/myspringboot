package jdk.collections;

import java.util.ArrayDeque;

/**
 * Feng, Ge 2021/7/22 0022 16:29
 */
public class ArrayDequeDemo {
    public static void main(String[] args) {
        //可以作为栈来使用，先进后出
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.push("book01");
        arrayDeque.push("book03");
        arrayDeque.push("book02");
        arrayDeque.push("book04");

        System.out.println("原栈：" + arrayDeque);

        System.out.println("获取头部元素，但不删除该元素，peek(): " + arrayDeque.peek());
        System.out.println("获取头部元素，且删除该元素，pop(): " +arrayDeque.pop());
        System.out.println("获取第一个元素，但不删除：" + arrayDeque.getFirst());
        System.out.println("获取最后一个元素，但不删除：" + arrayDeque.getLast());

        System.out.println("在双端队列头部插入元素：" + arrayDeque.offerFirst("booknew01"));
        System.out.println("在双端队列尾部插入元素：" + arrayDeque.offerLast("booknew02"));
        System.out.println("新栈：" + arrayDeque);
    }
}
