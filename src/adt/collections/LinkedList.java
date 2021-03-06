package adt.collections;

import adt.collections.interfaces.List;

/**
 * Created by Jógvan 23/12-2015 15:52.
 */
public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;

    private int size = 0;

    public void add(T item){
        Node<T> newNode = new Node<>(item);
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public void add(T item, int index){
        if(index>this.size)
            throw new IndexOutOfBoundsException("List is '"+this.size+"' you are trying to add at '"+index+"'");
        Node<T> newNode = new Node<>(item);

        if(index==0){
            newNode.next = this.head;
            this.head = newNode;
        }else{
            Node<T> addBehind = find(index);
            newNode.next = addBehind.next;
            addBehind.next = newNode;
        }

        this.size++;
    }

    public void set(T item, int index){
        if(index>this.size)
            throw new IndexOutOfBoundsException("List is '"+this.size+"' you are trying to set at '"+index+"'");
        Node<T> tmp = this.head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.data = item;
    }

    private Node<T> find(int index){
        Node<T> curr = this.head;
        for (int i = 0; i <index ; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public T get(int index){
        if(head==null || (index<0 && index>this.size)){
            throw new IndexOutOfBoundsException("List is '"+this.size+"' you are trying to get '"+index+"'");
        }else{
            return find(index).data;
        }
    }

    @Override
    public boolean contains(T o) {
        Node<T> tmp = head;
        while(tmp!=null){
            if(tmp.data.equals(o)) return true;
            tmp = tmp.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    // TODO: Implement method!
    @Override
    public void remove(int index) {

    }


    /* ********** Node ********** */
    private static class Node<T>{
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }
}
