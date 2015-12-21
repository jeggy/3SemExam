package generics;
/**
 * Created by Jógvan 20/12-2015 12:05.
 */
public class Main {

    public static void main(String[] args) {

        MyList<String> list = new MyList<>(3);
        list.add(0, "3");
        list.add(1, "5");
        System.out.println(list.get(0));

        MyList<MyList> list2 = new MyList<>(3);
        list2.add(0, list);
        System.out.println(list2);

    }

}
