package GOF.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConcreteCommand extends Command{

    private Receiver receiver;

    @Override
    public void execute() {
        receiver.action();
    }
}
