package sample;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class KeyEventManager {

    private Map<KeyCode, List<EventHandler<KeyEvent>>> handlers;

    public KeyEventManager() {
        this.handlers = new EnumMap<>(KeyCode.class);
    }

    public void addHandler(KeyCode keyCode, EventHandler<KeyEvent> handler) {
        List<EventHandler<KeyEvent>> handlersForKey = this.handlers.putIfAbsent(keyCode, new ArrayList<>());
        if (handlersForKey == null) {
            this.handlers.get(keyCode).add(handler);
        } else {
            handlersForKey.add(handler);
        }
    }

    public void handleKey(KeyEvent e) {
        List<EventHandler<KeyEvent>> handlersForKey = this.handlers.get(e.getCode());
        if (handlersForKey != null) {
            for (EventHandler<KeyEvent> handler : handlersForKey) {
                handler.handle(e);
            }
        }
    }

}

