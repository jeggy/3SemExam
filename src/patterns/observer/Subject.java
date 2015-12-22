package patterns.observer;

/**
 * Created by Jógvan 22/12-2015 14:32.
 */
public interface Subject {

    void subscribe(Observer ob);
    void unSubscribe(Observer ob);
    void notifyOthers();

}
