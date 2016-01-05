package patterns.singleton;

/**
 * Created by Jógvan 03/01-2016 18:12.
 */
public class Obby {

    private int num;

    private static Obby instance;

    public static Obby instance(int num){
        if(instance == null) {
            instance = new Obby();
        }
        instance.num = num;
        return instance;
    }

    private Obby(){}

    @Override
    public String toString() {
        return "Obby{" +
                "num=" + num +
                '}';
    }
}
