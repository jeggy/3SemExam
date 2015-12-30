package adt.collections;

import adt.collections.interfaces.ListInterface;

import java.util.Arrays;

/**
 * Created by Jógvan 20/12-2015 16:09.
 */
public class List<T> implements ListInterface<T> {

    private T[] list;

    private int size;

    public List(int size) {
        this.size = 0;
        this.list = (T[]) new Object[size];
    }

    @Override
    public void add(T o) {
        if(this.list.length<this.size)
            throw new IndexOutOfBoundsException("Array is full, you'll need to remove a element or create a new List!");

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
    public boolean contains(T o) {
        // TODO: implement this.
        return false;
    }

    @Override
    public String toString() {
        return "List{" +
                "list=" + Arrays.toString(list) +
                '}';
    }
}
