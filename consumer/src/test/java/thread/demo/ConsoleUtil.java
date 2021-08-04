package thread.demo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;

public class ConsoleUtil {

    public static void print(String msg){
        Console.log(DateUtil.now() + " " + msg);
    }
}
