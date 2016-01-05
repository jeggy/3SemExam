package patterns.singleton;

/**
 * Created by Jógvan 03/01-2016 18:09.
 */
public class Main {

    public static void main(String[] args) {
        Obby ob = Obby.instance(2);
        System.out.println(ob.toString());
        
        Obby ob2 = Obby.instance(5);
        System.out.println(ob.toString());
    }

}
