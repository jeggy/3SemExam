package adt.collections;

import adt.collections.interfaces.Stack;
import adt.collections.iterators.NegativeListIterator;
import exceptions.StackOutOfBoundsException;

import java.util.Iterator;

/**
 * Created by Jógvan 29/12-2015 16:25.
 */
public class SimpleStack<T> implements Stack<T> {

    private T[] stack = (T[]) new Object[5];
    private int size = 0;

    @Override
    public void push(T obj) {
        if(this.size>=this.stack.length){grow();}
        this.stack[this.size++] = obj;
    }

    @Override
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
        for (T t : stack)
            if(t.equals(o))
                return true;
        return false;
    }

    private void grow() {
        T[] na = (T[]) new Object[this.stack.length*2];
        System.arraycopy(this.stack, 0, na, 0, this.size);
        this.stack = na;
    }

    @Override
    public Iterator<T> iterator() {
        return new NegativeListIterator<>(stack, this.size);
    }
}
