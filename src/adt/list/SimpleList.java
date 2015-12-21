package adt.list;

/**
 * Created by Jógvan 20/12-2015 16:09.
 */
public class SimpleList<T> implements List<T>{

    private T[] list;

    private int size;

    public SimpleList(int size) {
        this.size = 0;
        this.list = (T[]) new Object[size];
    }

    @Override
    public void add(T o, int index) {

    }

    public void add(T o) {
        this.add(o, this.size-1);
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public int size() {
        return this.size;
    }
}
