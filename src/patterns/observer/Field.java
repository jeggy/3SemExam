package patterns.observer;

import javafx.scene.control.TextField;

/**
 * Created by Jógvan 30/12-2015 14:31.
 */
public class Field extends TextField implements ObserverInterface{
    private TextField follow;

    public Field(String name, TextField follow) {
        super(name);
        this.follow = follow;
        this.setEditable(false);


        Observer observer = new Observer();
        observer.addObserver(this);
    }

    @Override
    public void update() {
        this.setText(follow.getText());
    }
}
