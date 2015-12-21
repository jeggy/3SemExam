package generics;

import java.util.Arrays;

/**
 * Created by Jógvan 20/12-2015 12:15.
 */
public class MyList<T> {

    private T[] list;

    public MyList(int size) {
        list = (T[]) new Object[size];
    }

    public void add(int index,T s) {
        if(index>list.length)
            throw new IndexOutOfBoundsException("");

        list[index] = s;

    }

    public T get(int index){
        if(index>list.length)
            throw new IndexOutOfBoundsException("");
        return list[index];
    }

    @Override
    public String toString() {
        return "MyList{" +
                "list=" + Arrays.toString(list) +
                '}';
    }


    /* ----------- Generics method ----------- */
    public static <G> int v(G b){
        return b.hashCode();
    }
}
