package adt.lists;

/**
 * Created by Jógvan 21/12-2015 13:59.
 */
public class Iterator<T> implements java.util.Iterator<T> {

    private T[] list;
    private int size;
    private int currentPosition = 0;
    public Iterator(T[] list, int size) {
        this.list = list;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return size>this.currentPosition;
    }

    @Override
    public T next() {
        return this.list[currentPosition++];
    }
}
