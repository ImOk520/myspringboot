package GOF.interpreter;

import cn.hutool.core.lang.Console;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        List<Expression> list = new ArrayList<>();

        list.add(new TerminalExpression());
        list.add(new NonTerminalExpression());
        list.add(new TerminalExpression());
        list.add(new TerminalExpression());

        for (Expression abstractExpression : list) {
            Console.log(abstractExpression.interpret(context));
        }
    }
}
