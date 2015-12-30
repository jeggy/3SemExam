package adt.collections;

/**
 * Created by Jógvan 29/12-2015 17:08.
 */
public interface StackInterface<T> extends Collection<T> {

    void push(T obj);
    T pop();
    T peek();


}
