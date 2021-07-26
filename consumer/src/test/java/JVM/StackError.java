package JVM;

import cn.hutool.core.lang.Console;

public class StackError {
    private static int count = 1;
    public static void main(String[] args) {
        Console.log(count);
        count ++;
        main(args);
    }
}
