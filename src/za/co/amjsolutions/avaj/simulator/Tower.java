package za.co.amjsolutions.avaj.simulator;

import java.util.ArrayList;

/**
 * The observer pattern is a software design  pattern in which an object
 * maintains a list of it dependents and notifies them automatically of
 * any state changes, usually by calling one of their methods.
 *
 * @author jmsimang
 */
public class Tower {
    private final ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        if (observers.contains(flyable))
            return;
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        int index = observers.indexOf(flyable);
        observers.remove(index);
        Logger.getLogger().runLogger("Tower says: ");
    }

    protected void conditionsChanged() {
        for (Flyable observer : observers) observer.updateConditions();
    }
}
