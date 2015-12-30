package adt.collections;

import exceptions.StackOutOfBoundsException;

import java.util.Iterator;

/**
 * Created by Jógvan 29/12-2015 16:25.
 */
public class Stack<T> implements StackInterface<T>, Iterable<T>{

    private T[] stack = (T[]) new Object[5];
    private int size = 0;

    public void push(T obj) {
        if(this.size>=this.stack.length){grow();}
        this.stack[this.size++] = obj;
    }

    public T pop() {
        if(this.size>0){
            return this.stack[--this.size];
        }
        throw new StackOutOfBoundsException("Stack is empty!");
    }

    @Override
    public T peek() {
        return this.stack[this.size-1];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(T o) {
        // TODO: Implement this!
        return false;
    }

    private void grow() {
        T[] na = (T[]) new Object[this.stack.length*2];
        System.arraycopy(this.stack, 0, na, 0, this.size);
        this.stack = na;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO: implement this!
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }
}
