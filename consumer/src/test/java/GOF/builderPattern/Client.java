package GOF.builderPattern;


import cn.hutool.core.lang.Console;

/**
 * Feng, Ge 2021/4/20 0020 11:09
 */
public class Client {
    public static void main(String[] args) {
        PersonDraw personDraw = new PersonDraw.Builder("头", "手", "脚", "身体")
                .setClothes("衣服")
                .build();
        Console.log(personDraw.toString());
        Console.log(personDraw.getFoot());
    }
}
