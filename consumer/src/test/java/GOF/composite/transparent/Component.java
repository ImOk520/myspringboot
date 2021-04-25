package GOF.composite.transparent;

import java.util.List;

public abstract class Component {
    //个体和整体都具有
    public void operation(){
        //编写业务逻辑
    }
    //增加一个叶子构件或树枝构件
    public abstract void add(Component component);
    //删除一个叶子构件或树枝构件
    public abstract void remove(Component component);
    //获得分支下的所有叶子构件和树枝构件
    public abstract List<Component> getChildren();
}
