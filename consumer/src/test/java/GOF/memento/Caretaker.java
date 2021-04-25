package GOF.memento;

/**
 * 负责管理Memoto
 */
public class Caretaker {
    //备忘录
    Memento memento;

    //存档
    public void archive(Memento memoto){
        this.memento = memoto;
    }

    //获取存档
    public Memento getMemoto(){
        return memento;
    }
}