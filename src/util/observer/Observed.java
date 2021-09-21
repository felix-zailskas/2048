package util.observer;

import java.util.ArrayList;

public class Observed {
    protected ArrayList<Listener> listeners;

    public void addObserver(Listener o) {
        this.listeners.add(o);
    }

    protected void notifyListeners() {
        listeners.forEach(listener -> {
            listener.handleUpdate();
        });
    }
}
