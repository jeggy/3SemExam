package generics.extend;

/**
 * Created by Jógvan 20/12-2015 14:32.
 */
public class Volvo extends Vehicle {
    public Volvo(String s) {
        super(s+"(Volvo)", 500, 3500);
        this.startDriving();
    }
}
