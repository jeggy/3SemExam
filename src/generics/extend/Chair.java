package generics.extend;

/**
 * Created by Jógvan 20/12-2015 12:57.
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
