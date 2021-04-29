package GOF.iterator;

public interface Aggregate<T> {

    /**
     * 添加一个对象
     * @param t
     */
    void add(T t);

    /**
     * 删除的对象
     * @param t
     */
    void remove(T t);

    /**
     * 获取容器的迭代器
     * @return
     */
    Iterator<T> iterator();

}

