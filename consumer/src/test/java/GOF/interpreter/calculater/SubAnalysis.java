package GOF.interpreter.calculater;

import java.util.HashMap;

public class SubAnalysis extends SymbolAnalysis {

    public SubAnalysis(Expression left, Expression right) {
        super(left, right);
    }

    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }
}
