package adt.collections.iterators;

import java.util.Iterator;

/**
 * Created by Jógvan 30/12-2015 17:15.
 */
public class NegativeListIterator<T> implements Iterator<T> {

    private T[] list;
    private int pos;

    public NegativeListIterator(T[] list, int size){
        this.list = list;
        this.pos = size;
    }

    @Override
    public boolean hasNext() {
        return pos>0;
    }

    @Override
    public T next() {
        return list[--pos];
    }
}
