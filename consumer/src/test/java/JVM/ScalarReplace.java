package JVM;

/**
 * 标量替换测试
 * 参数设置
 *      -Xms100m -Xmx100m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations  (关闭标量替换)
 *      -Xms100m -Xmx100m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations  (开启标量替换)
 */
public class ScalarReplace {
    public static class User{
        public int id;
        public String name;
    }
    public static void alloc(){
        User user = new User();//未发生逃逸
        user.id = 1;
        user.name = "Lemon";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0;i < 100000000;i++){
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start) + "ms");
    }
}

