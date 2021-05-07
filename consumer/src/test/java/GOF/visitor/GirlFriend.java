package GOF.visitor;

import cn.hutool.core.lang.Console;

/**
 * 抽象访问者 —— 女朋友
 */
public class GirlFriend implements Visitor{
    @Override
    public void visit(PersonalitySonInLaw personalitySonInLaw) {
        Console.log(personalitySonInLaw.getPersonality() + "我喜欢！");
    }

    @Override
    public void visit(RichSonInLaw richSonInLaw) {
        Console.log("爱情价更高！");
    }
}
