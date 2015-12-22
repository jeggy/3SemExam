package patterns.observer;

import java.util.ArrayList;

/**
 * Created by Jógvan 22/12-2015 14:32.
 */
public class ConcreteSubject implements Subject{

    private ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer ob) {
        observers.add(ob);
    }

    @Override
    public void unSubscribe(Observer ob) {
        observers.remove(ob);
    }

    @Override
    public void notifyOthers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
