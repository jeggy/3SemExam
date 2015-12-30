package adt.collections.interfaces;

/**
 * Created by Jógvan 30/12-2015 17:32.
 */
public interface Queue<T> extends Collection<T>, Iterable<T>{

    void add(T o);
    T peek();
    T poll();

}
