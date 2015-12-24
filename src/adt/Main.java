package adt;

import adt.lists.HashSet;

import java.util.Arrays;

/**
 * Created by Jógvan 20/12-2015 15:53.
 */
public class Main {

    public static void main(String[] args) {
//        SimpleList<String> list = new SimpleList<>(10);
//
//        list.add("Entry 1");
//        list.add("Entry 2");
//        list.add("Entry 3");
//
//        System.out.println(list);

//        GenericList<String> list = new GenericList<>();
//        list.add("Entry 1");
//        list.add("Entry 2");
//        list.add("Entry 3");
//        list.add("Entry 4");
//        list.add("Entry 5");
//        list.add("Entry 6");
//
//
//        Iterator<String> i = list.iterator();
//        while(i.hasNext())
//            System.out.println(i.next());
//
//        System.out.println(list);


//        LinkedStack<String> l = new LinkedStack<>();
//        l.push("Hello");
//        l.push("Hello2");
//        l.push("Hello3");
//        l.push("Hello4");
//        l.push("Hello5");
//        l.pop();
//        l.pop();
//        System.out.println(l.pop());

        HashSet<String> set = new HashSet<>();
        set.add("Hello1");
        set.add("Hellfweao2");
        set.add("Hellfao3");
        set.add("Hfe2lo%4");

        System.out.println(Arrays.toString(set.toArray()));


//        LinkedList<String> ll = new LinkedList<>();
//        ll.add("Hello");
//        ll.add("Hello2");
//        ll.add("Hello3");
//        System.out.println(ll.get(0));

    }
}
