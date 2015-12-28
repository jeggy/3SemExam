package adt.collections;

/**
 * Created by Jógvan 23/12-2015 13:46.
 */
public class LinkedStack<T> {

    private Node<T> head;
    private int size = 0;

    public void push(T o){
        Node tmp = this.head;
        this.head = new Node<>(o, tmp);
        this.size++;
    }

    public T pop(){
        T r = this.head.data;
        this.head = this.head.next;
        return r;
    }

    public T peek(){
        return this.head.data;
    }

    public int getSize(){
        return this.size;
    }

    public void printAll(){
        Node tmp = this.head;
        while(tmp!=null){
            System.out.print(", "+tmp.data);
            tmp = tmp.next;
        }
    }

    private static class Node<T>{
        Node<T> next;
        T data;
        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
