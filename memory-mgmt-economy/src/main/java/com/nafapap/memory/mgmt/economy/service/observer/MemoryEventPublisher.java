package com.nafapap.memory.mgmt.economy.service.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PapaFan
 */
public class MemoryEventPublisher {

    private final List<MemoryEventListener> listeners = new ArrayList<>();

    public void methodToMonitor(Object s) {

    }

    protected <E extends MemoryEvent> void publishEvent(String status,
                                                        E memoryEvent) {
        List<MemoryEventListener> copyListeners =
                new ArrayList<>(listeners);
        for (MemoryEventListener listener : copyListeners) {
            if ("BEGIN".equals(status)) {
                listener.onMethodBegin(memoryEvent);
            } else {
                listener.onMethodEnd(memoryEvent);
            }

            listener.doSomething(memoryEvent);
        }
    }

    public void addListener(MemoryEventListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(MemoryEventListener listener) {
        this.listeners.remove(listener);
    }

    public void clearListeners() {
        this.listeners.clear();
    }

    //public static void main(String[] args) {
    //    MemoryEventPublisher eventPublisher =
    //            new MemoryEventPublisher();
    //    eventPublisher.addListener(new SimpleMemoryEventListener());
    //    eventPublisher.methodToMonitor("594431");
    //}
}