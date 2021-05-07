package GOF.visitor;

import cn.hutool.core.lang.Console;

/**
 * 具体访问者 —— 丈母娘
 */
public class MotherInLaw implements Visitor{
    @Override
    public void visit(PersonalitySonInLaw personalitySonInLaw) {
        Console.log("我是丈母娘，人品都是浮云，重要的是要有钱！");
    }

    @Override
    public void visit(RichSonInLaw richSonInLaw) {
        Console.log(richSonInLaw.getMoney() + "的金龟婿我喜欢！");
    }
}
