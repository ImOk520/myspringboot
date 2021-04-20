package GOF.builderPattern;

import lombok.Getter;
import lombok.ToString;

/**
 * 建造者模式：
 * 当一个类的构造函数参数个数超过4个，而且这些参数有些是可选的参数，考虑使用构造者模式。
 *
 * 人物绘制
 * 我们要画一个人，这个人有头、手、脚、身体这些必选项，也有衣服、鞋子、帽子这些可选项。
 * Feng, Ge 2021/4/20 0020 10:29
 */
@Getter
@ToString
public class PersonDraw {
    // 必选属性
    private String head;
    private String hand;
    private String foot;
    private String body;
    // 可选项
    private String clothes;
    private String shoes;
    private String hat;

    public PersonDraw(Builder builder){
        this.head = builder.head;
        this.hand = builder.hand;
        this.foot = builder.foot;
        this.body = builder.body;
        this.clothes = builder.clothes;
        this.shoes = builder.shoes;
        this.hat = builder.hat;
    }

    public static class Builder {
        // 必选属性
        private String head;
        private String hand;
        private String foot;
        private String body;
        // 可选项
        private String clothes;
        private String shoes;
        private String hat;

        public Builder (String head, String hand, String foot, String body){
            this.head = head;
            this.hand = hand;
            this.foot = foot;
            this.body = body;
        }

        public Builder setClothes(String clothes){
            this.clothes = clothes;
            return this;
        }

        public Builder setShoes(String shoes) {
            this.shoes = shoes;
            return this;
        }

        public Builder setHat(String hat) {
            this.hat = hat;
            return this;
        }

        public PersonDraw build(){
            return new PersonDraw(this);
        }
    }
}
