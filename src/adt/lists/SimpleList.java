package adt.lists;

import java.util.Arrays;

/**
 * Created by Jógvan 20/12-2015 16:09.
 */
public class SimpleList<T> implements Collection<T> {

    private T[] list;

    private int size;

    public SimpleList(int size) {
        this.size = 0;
        this.list = (T[]) new Object[size];
    }

    @Override
    public void add(T o) {
        if(this.list.length<this.size)
            throw new IndexOutOfBoundsException("Array is full, you'll need to remove a element or create a new SimpleList!");

        this.list[this.size++] = o;
    }

    @Override
    public T get(int index) {
        return this.list[index];
    }

    @Override
    public void remove(int index) {
        this.list[index] = null;
        this.size--;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return "SimpleList{" +
                "list=" + Arrays.toString(list) +
                '}';
    }
}
