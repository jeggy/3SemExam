package adt.collections;

/**
 * Created by Jógvan 27/12-2015 22:45.
 */
public interface ListInterface<T> extends Collection<T>{

    void add(T o);
    T get(int index);
    void remove(int index);

}
