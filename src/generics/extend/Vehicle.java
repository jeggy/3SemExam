package generics.extend;

/**
 * Created by jeggy on 12/20/15.
 */
public abstract class Vehicle implements ThingInterface, Drivable {

    private String description;
    private int size;
    private boolean driving;
    private final long speed;

    public Vehicle(String s, int i, long speed) {
        this.speed = speed;
        this.description = s;
        this.size = i;
    }


    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double size() {
        return size;
    }

    @Override
    public void startDriving() {
        this.driving = true;
        new Thread(this).start();
    }

    @Override
    public void stopDriving() {
        this.driving = false;
    }

    @Override
    public void run() {
        try{
            while (driving) {
                Thread.sleep(speed);
                System.out.println(this+": Drove a bit");
            }
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
