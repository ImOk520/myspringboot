package JVM;

import cn.hutool.core.lang.Console;

public class ClassLoaderTest {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("JVM.GetClassLoader");
            ClassLoader classLoader = aClass.getClassLoader();
            Console.log("【1】{}", classLoader);
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            Console.log("【2】{}", contextClassLoader);
            ClassLoader parent = ClassLoader.getSystemClassLoader().getParent();
            Console.log("【3】{}", parent);
            Thread.sleep(100000000);
        } catch (ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
