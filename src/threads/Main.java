package threads;

/**
 * Created by Jógvan 21/12-2015 17:59.
 */
public class Main implements Runnable{

    public static void main(String[] args) {
        new Thread(new Main()).start();
        System.out.println("Hello World!");
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(4000);
                System.out.println("Hello there :O");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
