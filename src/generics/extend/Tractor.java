package generics.extend;

/**
 * Created by Jógvan 20/12-2015 13:52.
 */
public class Tractor extends Vehicle{
    public Tractor(String s) {
        super(s, 1000, 15000);
        this.startDriving();
    }
}
