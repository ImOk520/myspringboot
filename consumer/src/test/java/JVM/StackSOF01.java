package JVM;

import thread.demo.ConsoleUtil;

public class StackSOF01 {
    private int stackLength = 1;

    public void stackLeak() {
        System.out.println("stackLength:" + stackLength);
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackSOF01 stackSOF01 = new StackSOF01();

            stackSOF01.stackLeak();

    }
}
