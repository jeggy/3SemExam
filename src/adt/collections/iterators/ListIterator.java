package adt.collections.iterators;

import java.util.Iterator;

/**
 * Created by Jógvan 27/12-2015 22:41.
 */
public class ListIterator<T> implements Iterator<T> {

    private T[] list;
    private int pos = 0;

    public ListIterator(T[] list){
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list[pos+1]!=null;
    }

    @Override
    public T next() {
        return list[pos++];
    }
}
