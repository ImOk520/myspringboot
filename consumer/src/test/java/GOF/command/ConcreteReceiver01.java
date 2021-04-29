package GOF.command;

import cn.hutool.core.lang.Console;

/**
 * Feng, Ge 2021/4/29 0029 14:06
 */
public class ConcreteReceiver01 extends Receiver{

    @Override
    public void action() {
        Console.log("接收者【01】接到指令！开始行动！");
    }
}
