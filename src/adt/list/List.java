package adt.list;

/**
 * Created by Jógvan 20/12-2015 16:10.
 */
public interface List<T> {

    void add(T o, int index);
    T get(int index);
    void remove(int index);
    int size();

}
