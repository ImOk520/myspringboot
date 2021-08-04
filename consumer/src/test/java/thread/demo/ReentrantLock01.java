package thread.demo;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock01 {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();

        try {
            method1();
            lock.unlock();
        } finally {

        }
    }

    public static void method1() {
        lock.lock();
        try {
            ConsoleUtil.print("execute method1");
            method2();
        } finally {
            lock.unlock();
        }
    }
    public static void method2() {
        lock.lock();
        try {
            ConsoleUtil.print("execute method2");
            method3();
        } finally {
            lock.unlock();
        }
    }
    public static void method3() {
        lock.lock();
        try {
            ConsoleUtil.print("execute method3");
        } finally {
            lock.unlock();
        }
    }
}
