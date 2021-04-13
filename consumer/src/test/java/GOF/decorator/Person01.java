package GOF.decorator;


import cn.hutool.core.lang.Console;
import lombok.AllArgsConstructor;

/**
 * 如果不使用装饰模式，
 *
 * Feng, Ge
 */
@AllArgsConstructor
public class Person01 {

    private String name;

    public String wearTShirt(){
        return "大T恤";
    }

    public String wearTrousers(){
        return "垮裤";
    }

    public String wearShoes(){
        return "洞洞鞋";
    }

    public String wearLeatherShoes(){
        return "皮鞋";
    }

    public String wearSuit(){
        return "西装";
    }

    public String wearTie(){
        return "红领带";
    }

    public void show(StringBuilder msg){
        Console.log(msg);
    }

    public static void main(String[] args) {
        Person01 person = new Person01("王富贵");

        StringBuilder msg_01 = new StringBuilder("第一套装扮：");
        StringBuilder msg_02 = new StringBuilder("第二套装扮：");

        msg_01.append(person.wearTShirt())
                .append(person.wearShoes())
                .append(person.wearTie());

        msg_02.append(person.wearTrousers())
                .append(person.wearLeatherShoes())
                .append(person.wearTie());

        person.show(msg_01);
        person.show(msg_02);
    }
}
