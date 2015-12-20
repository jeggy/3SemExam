package generics.extend;

/**
 * Created by jeggy on 12/20/15.
 */
public class Tractor extends Vehicle{
    public Tractor(String s) {
        super(s, 1000, 15000);
        this.startDriving();
    }
}
