package GOF.composite.transparent;

import java.util.List;

public class Leaf extends Component {

    public void add(Component component){
        //空实现
    }

    public void remove(Component component){
        //空实现
    }

    public List<Component> getChildren(){
        //空实现
        return null;
    }
}

