package generics.extend;

/**
 * Created by Jógvan 20/12-2015 12:47.
 */
public class Main {

    static ThingInterface[] things = {new Volvo("This is a car"),
            new Tractor("This is a car"),
            new Chair(4),
            new Triangle()
    };

    public static void main(String[] args) {
        printAll(things);
    }

    public static<T extends ThingInterface> void printAll(T[] all){
        for (T t : all) {
            System.out.println(t.getDescription()+" : "+t.size()+" in size");
        }
    }

}
