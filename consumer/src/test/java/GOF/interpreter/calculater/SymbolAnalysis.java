package GOF.interpreter.calculater;

import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
public class SymbolAnalysis extends Expression {
    protected Expression left;
    protected Expression right;

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return 0;
    }
}
