package adt.collections;

import adt.collections.iterators.ListIterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Jógvan 21/12-2015 13:26.
 */
public class GenericList<T> implements ListInterface<T>, Iterable<T>, Iterator<T> {

    private T[] list = (T[]) new Object[20];
    private int size = 0;

    @Override
    public void add(T o) {
        if(this.list.length<=this.size)
            grow();
        this.list[this.size++] = o;
    }

    @Override
    public T get(int index) {
        if(this.size<index)
            throw new IndexOutOfBoundsException("The list is only "+this.size+" in size!");
        return this.list[index];
    }

    @Override
    public void remove(int index) {
        if(this.size<index)
            throw new IndexOutOfBoundsException("The list is only "+this.size+" in size!");
        this.list[--this.size] = null;
    }

    public void remove(T obj){
        for (int i = 0; i < this.size; i++) {
            if(this.list[i].equals(obj)){
                this.list[i] = null;
                this.size--;
                return;
            }
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(T o) {
        for (T t : list) {
            if(o.equals(t))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        T[] r = (T[]) new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            r[i] = this.list[i];
        }
        return Arrays.toString(r);
    }

    public Iterator<T> iterator(){
        return new ListIterator<>(list);
    }

    private void grow() {
        T[] newList = (T[]) new Object[this.size*2];
        for (int i = 0; i < this.size; i++) {
            newList[i] = this.list[i];
        }
        this.list = newList;
    }

    /* Iterator, Iterable */
    private int ic = 0;

    @Override
    public boolean hasNext() {
        return this.list[ic+1] != null;
    }

    @Override
    public T next() {
        return this.list[ic++];
    }
}
