package patterns.mediator;

import javafx.scene.control.Label;

/**
 * Created by Jógvan 26/12-2015 03:32.
 */
public class JObject2 extends Label implements MediatorComponent {

    public JObject2(String text) {
        super(text);
    }

    @Override
    public void update(String t) {

    }
}
