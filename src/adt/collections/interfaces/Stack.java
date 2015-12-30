package adt.collections.interfaces;

/**
 * Created by Jógvan 29/12-2015 17:08.
 */
public interface Stack<T> extends Collection<T>, Iterable<T> {

    void push(T obj);
    T pop();
    T peek();

}
