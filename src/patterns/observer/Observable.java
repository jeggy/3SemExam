package patterns.observer;

import java.util.ArrayList;

/**
 * Created by Jógvan 30/12-2015 14:18.
 */
public class Observable {

    private static ArrayList<ObserverInterface> observers = new ArrayList<>();

    public void addObserver(ObserverInterface ob){
        observers.add(ob);
    }

    public void notifyObservers(){
        observers.forEach(ObserverInterface::update);
    }

}
