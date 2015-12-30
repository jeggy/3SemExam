package adt.collections.iterators;

import adt.collections.LinkedQueue;

import java.util.Iterator;

/**
 * Created by Jógvan 30/12-2015 17:54.
 */
public class LinkedQueueIterator<T> implements Iterator<T> {

    LinkedQueue<T> lq;

    public LinkedQueueIterator(LinkedQueue<T> lq) {
        this.lq = lq;
    }

    @Override
    public boolean hasNext() {
        return lq.size()>0;
    }

    @Override
    public T next() {
        return lq.poll();
    }
}
