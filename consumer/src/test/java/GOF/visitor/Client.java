package GOF.visitor;

import cn.hutool.core.lang.Console;

/**
 * Feng, Ge 2021/5/2 0002 21:58
 */
public class Client {
    public static void main(String[] args) {

        ScoreTable scoreTable = new ScoreTable();
        scoreTable.showScoredTable(new MotherInLaw());
        Console.log("====================");
        scoreTable.showScoredTable(new GirlFriend());
    }
}
