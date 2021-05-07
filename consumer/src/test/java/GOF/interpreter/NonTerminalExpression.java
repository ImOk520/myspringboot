package GOF.interpreter;

public class NonTerminalExpression extends Expression {

    @Override
    public String interpret(Context context) {
        return "非终端解释器";
    }
}
