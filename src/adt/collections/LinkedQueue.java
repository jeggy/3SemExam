package adt.collections;

import adt.collections.interfaces.Queue;
import adt.collections.iterators.LinkedQueueIterator;
import exceptions.QueueEmptyException;

import java.util.Iterator;

/**
 * Created by Jógvan 30/12-2015 17:27.
 */
public class LinkedQueue<T> implements Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    @Override
    public void add(T o) {
        Node<T> nn = new Node<>(o);
        if(head==null){
            head = nn;
            tail = nn;
        }else{
            tail.next = nn;
            tail = nn;
        }
        this.size++;
    }

    @Override
    public T peek() {
        return head.data;
    }

    @Override
    public T poll() {
        if(this.size>0){
            T r = head.data;
            head = head.next;
            this.size--;
            return r;
        }
        throw new QueueEmptyException("Queue is empty!");
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(T o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedQueueIterator<>(this);
    }


    static class Node<T>{
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
