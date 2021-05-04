package GOF.interpreter.calculater;

import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
public class VarAnalysis extends Expression {
    private String key;

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return  var.get(this.key);
    }
}
