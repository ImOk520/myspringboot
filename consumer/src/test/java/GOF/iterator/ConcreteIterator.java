package GOF.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteIterator<T> implements Iterator<T> {

    /**
     * 模拟用一个 List
     */
    private List<T> mList = new ArrayList<>();

    private int cursor = 0;


    public ConcreteIterator(List<T> list) {
        this.mList = list;
    }

    @Override
    public boolean hasNext() {
        return cursor != mList.size();
    }

    @Override
    public T next() {
        //定义一个临时变量
        T obj = null;
        if (this.hasNext()) {
            obj = this.mList.get(cursor++);
        }
        return obj;
    }
}

