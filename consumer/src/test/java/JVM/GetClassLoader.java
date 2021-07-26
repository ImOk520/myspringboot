package JVM;

import cn.hutool.core.lang.Console;

public class GetClassLoader {
    public static void main(String[] args) {
        ClassLoader classLoader = GetClassLoader.class.getClassLoader();
        Console.log("[classLoader]:{}", classLoader);
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Console.log("[systemClassLoader]:{}", systemClassLoader);
        ClassLoader parent = systemClassLoader.getParent();
        Console.log("[parent]:{}", parent);
        ClassLoader parentParent = parent.getParent();
        Console.log("[parentParent]:{}", parentParent);

        ClassLoader stringClassLoader = String.class.getClassLoader();
        Console.log("[stringClassLoader]:{}", stringClassLoader);
    }
}
