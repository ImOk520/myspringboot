package GOF.interpreter.calculater;

import java.util.HashMap;

public class AddAnalysis extends SymbolAnalysis {
    public AddAnalysis(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
