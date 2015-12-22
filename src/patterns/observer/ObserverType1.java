package patterns.observer;

/**
 * Created by Jógvan 22/12-2015 14:40.
 */
public class ObserverType1 implements Observer {

    private ConcreteSubject concreteSubject;

    public ObserverType1(ConcreteSubject concreteSubject) {
        this.concreteSubject = concreteSubject;
    }

    @Override
    public void update() {

    }
}
