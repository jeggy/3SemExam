package adt;

import adt.collections.*;
import adt.collections.interfaces.Map;
import adt.collections.interfaces.Stack;

import java.util.Arrays;


/**
 * Created by Jógvan 20/12-2015 15:53.
 */
public class Main {

    public static void main(String[] args) {
        SimpleList<String> simpleList = new SimpleList<>(10);

        simpleList.add("Entry 1");
        simpleList.add("Entry 2");
        simpleList.add("Entry 3");

        System.out.println(simpleList);

        GenericList<String> genericList = new GenericList<>();
        genericList.add("Entry 1");
        genericList.add("Entry 2");
        genericList.add("Entry 3");
        genericList.add("Entry 4");
        genericList.add("Entry 5");
        genericList.add("Entry 6");

        for (int i = 0; i < genericList.size(); i++) {
            System.out.println(genericList.get(i));
        }

        for (String aList : genericList)
            System.out.println(aList);

        System.out.println(genericList);


        LinkedStack<String> ls = new LinkedStack<>();
        ls.push("Hello");
        ls.push("Hello2");
        ls.push("Hello3");
        ls.push("Hello4");
        ls.push("Hello5");
        ls.pop();
        ls.pop();
        System.out.println(ls.pop());

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hello1");
        hashSet.add("Hellfweao2");
        hashSet.add("Hellfao3");
        hashSet.add("Hellfao3");
        hashSet.add("Hfe2lo%4");

        System.out.println(Arrays.toString(hashSet.toArray()));


        LinkedList<String> ll = new LinkedList<>();
        ll.add("Hello");
        ll.add("Hello2");
        ll.add("Hello3");
        System.out.println(ll.get(0));

        Map<String, String> map = new HashMap<>();
        map.put("","");
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("33","c");
        map.put("34","bc");
        map.put("35","cd");
        map.put("311","ce");
        map.put("A","");
        map.put("A1","a");
        map.put("AA2","b");
        map.put("A3","c");
        map.put("A33","c");
        map.put("A34","bc");
        map.put("A35","cd");
        map.put("A311","ce");
        System.out.println(map.get("A35"));


        Stack<String> stack = new SimpleStack<>();

        for (int i = 0; i < 20; i++) {
            stack.push("Content"+i);
        }

        for (String s : stack) {
            System.out.println(s);
        }



        LinkedQueue<String> lq = new LinkedQueue<>();
        lq.add("Test1");
        lq.add("Test2");
        lq.add("Test3");


        for (String s : lq) {
            System.out.println(s);
        }
    }
}
