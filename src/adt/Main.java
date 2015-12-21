package adt;

import adt.list.GenericList;
import adt.list.SimpleList;

import java.util.Iterator;

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

        GenericList<String> list = new GenericList<>();
        list.add("Entry 1");
        list.add("Entry 2");
        list.add("Entry 3");
        list.add("Entry 4");
        list.add("Entry 5");
        list.add("Entry 6");


        Iterator<String> i = list.iterator();
        while(i.hasNext())
            System.out.println(i.next());

        System.out.println(list);
    }
}
