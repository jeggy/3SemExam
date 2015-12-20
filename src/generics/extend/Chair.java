package generics.extend;

/**
 * Created by jeggy on 12/20/15.
 */
public class Chair implements ThingInterface{

    private double size;

    public Chair(double size) {
        this.size = size;
    }

    @Override
    public String getDescription() {
        return "This is a chair.";
    }

    @Override
    public double size() {
        return size;
    }
}
