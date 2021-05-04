package GOF.bridge;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class WaterHeater {
    protected HeaterType heaterType;

    public abstract void heat();
}
