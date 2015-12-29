package adt;

import adt.collections.GenericList;
import adt.collections.HashMap;

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

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (String aList : list)
            System.out.println(aList);

        System.out.println(list);


//        LinkedStack<String> l = new LinkedStack<>();
//        l.push("Hello");
//        l.push("Hello2");
//        l.push("Hello3");
//        l.push("Hello4");
//        l.push("Hello5");
//        l.pop();
//        l.pop();
//        System.out.println(l.pop());
//
//        HashSet<String> set = new HashSet<>();
//        set.add("Hello1");
//        set.add("Hellfweao2");
//        set.add("Hellfao3");
//        set.add("Hellfao3");
//        set.add("Hfe2lo%4");
//
//        System.out.println(Arrays.toString(set.toArray()));
//
//
//        LinkedList<String> ll = new LinkedList<>();
//        ll.add("Hello");
//        ll.add("Hello2");
//        ll.add("Hello3");
//        System.out.println(ll.get(0));

        HashMap<String, String> test = new HashMap<>();
        test.put("","");
        test.put("1","a");
        test.put("2","b");
        test.put("3","c");
        test.put("33","c");
        test.put("34","bc");
        test.put("35","cd");
        test.put("311","ce");
        test.put("A","");
        test.put("A1","a");
        test.put("AA2","b");
        test.put("A3","c");
        test.put("A33","c");
        test.put("A34","bc");
        test.put("A35","cd");
        test.put("A311","ce");
        System.out.println(test.get("A35"));


    }
}
