package GOF.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Invoker {
    private Command command;

    public void call(){
        command.execute();
    }
}
