package GOF.interpreter;

public class TerminalExpression extends Expression {

    @Override
    public String interpret(Context context) {
        return "终端解释器";
    }
}