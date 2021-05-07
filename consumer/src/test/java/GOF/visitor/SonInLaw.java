package GOF.visitor;

import lombok.AllArgsConstructor;

/**
 * 抽象女婿类 —— 抽象元素
 */
public abstract class SonInLaw {

    private String name;
    // 有钱与否
    private String money;
    // 人品如何
    private String personality;

    public SonInLaw(String name) {
        this.name = name;
    }

    public abstract void accept(Visitor visitor);
}
