package patterns.mediator;

/**
 * Created by Jógvan 26/12-2015 02:17.
 */
public interface Mediator {

    void subscribe(MediatorComponent o);
    void unsubscribe(MediatorComponent o);
    void notifyComponents(MediatorComponent component);
}
