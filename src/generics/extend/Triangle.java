package generics.extend;

/**
 * Created by Jógvan 20/12-2015 13:58.
 */
public class Triangle implements ThingInterface, Shapeable {

    private int size = 25;

    @Override
    public String getDescription() {
        return "This is a triangle";
    }

    @Override
    public double size() {
        return size;
    }
}
