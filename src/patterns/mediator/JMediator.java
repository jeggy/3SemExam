package patterns.mediator;

import adt.lists.GenericList;

/**
 * Created by Jógvan 26/12-2015 02:27.
 */
public class JMediator implements Mediator{

    private GenericList<MediatorComponent> clients = new GenericList<>();

    public JMediator(String s) {

    }

    @Override
    public void subscribe(MediatorComponent o) {
        this.clients.add(o);
    }

    @Override
    public void unsubscribe(MediatorComponent o) {
        this.clients.remove(o);
    }

    @Override
    public void notifyComponents(MediatorComponent component) {
        for (MediatorComponent client : clients) {
            if (client.equals(component))
                client.update("");
            else
                client.update("");
        }
    }
}
