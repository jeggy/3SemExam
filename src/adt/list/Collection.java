package adt.list;

/**
 * Created by Jógvan 20/12-2015 16:10.
 */
public interface Collection<T> {

    void add(T o);
    T get(int index);
    void remove(int index);
    int size();

}
