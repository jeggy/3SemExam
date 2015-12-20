package generics.extend;

/**
 * Created by jeggy on 12/20/15.
 */
public class Volvo extends Vehicle {
    public Volvo(String s) {
        super(s+"(Volvo)", 500, 3500);
        this.startDriving();
    }
}
