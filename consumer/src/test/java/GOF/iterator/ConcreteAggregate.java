package GOF.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate<T> implements Aggregate<T>{

    /**
     * 模拟具体容器
     */
    private List<T> mLists = new ArrayList<>();

    @Override
    public void add(T t) {
        mLists.add(t);
    }

    @Override
    public void remove(T t) {
        mLists.remove(t);

    }

    @Override
    public Iterator<T> iterator() {
        return new ConcreteIterator<T>(mLists);
    }
}
