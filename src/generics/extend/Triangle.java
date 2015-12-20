package generics.extend;

/**
 * Created by jeggy on 12/20/15.
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
