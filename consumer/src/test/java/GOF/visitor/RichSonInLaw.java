package GOF.visitor;

import cn.hutool.core.lang.Console;

/**
 * 具体女婿类，有钱金龟女婿 —— 具体元素
 */

public class RichSonInLaw extends SonInLaw{

    public RichSonInLaw(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getMoney(){
        return "每年挣一亿￥";
    }

}
