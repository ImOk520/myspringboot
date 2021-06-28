package annotationTest;

import cn.hutool.core.lang.Console;
import org.junit.Test;

import java.lang.reflect.Modifier;

/**
 * Feng, Ge 2021/6/24 0024 19:56
 */
public class ModifierTest {

    @Test
    public void testModifier(){
        // 如果整数参数包含 {@code static} 修饰符，则返回 {@code true}，否则返回 {@code false}。
        Console.log("【1】" + Modifier.isStatic(8));
        Console.log("【2】" + Modifier.ABSTRACT);
        Console.log("【3】" + Modifier.STRICT);
        Console.log("【4】" + Modifier.STATIC);
        Console.log("【5】" + Modifier.PUBLIC);
        Console.log("【6】" + Modifier.PRIVATE);
        Console.log("【7】" + Modifier.PROTECTED);
        Console.log("【8】" + Modifier.TRANSIENT);
        Console.log("【9】" + Modifier.isPublic(1));
        Console.log("【10】" + Modifier.isFinal(1));
        Console.log("【11】" + Modifier.isAbstract(1));
        Console.log("【12】" + Modifier.isNative(1));
        Console.log("【13】" + Modifier.isSynchronized(1));
    }
}
