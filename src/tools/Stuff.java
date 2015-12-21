package tools;


import javafx.stage.Stage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jeggy on 9/11/15.
 */
public class Stuff extends Thread {

    // Example usage: startFXApplication("opgaver.others.calculator.Main");
    public static void startFXApplication(String className) {
        try {
            Class c = Class.forName(className);
            Object o = c.newInstance();
            Class[] params = new Class[1];
            params[0] = Stage.class;
            Method m = c.getDeclaredMethod("start", params);
            m.invoke(o, new Stage());
        } catch (ClassNotFoundException e) {
            System.out.println(className+" not found.");
        } catch (NoSuchMethodException e) {
            System.out.println(className+" doesn't have a start method.");
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
