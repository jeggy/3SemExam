package patterns.mediator;

import javafx.scene.control.Label;

/**
 * Created by Jógvan 26/12-2015 03:27.
 */
public class JObject1 extends Label implements MediatorComponent {

    public JObject1(String name) {
        super(name);
    }

    @Override
    public void update(String t) {

    }

}
