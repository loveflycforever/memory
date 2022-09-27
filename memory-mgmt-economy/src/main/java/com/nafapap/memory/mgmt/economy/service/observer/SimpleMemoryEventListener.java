package com.nafapap.memory.mgmt.economy.service.observer;

/**
 * @author PapaFan
 */
public class SimpleMemoryEventListener implements MemoryEventListener {
 
    @Override
    public <E extends MemoryEvent> void onMethodBegin(E event) {
        String methodName = event.getMethodName();
        System.out.println("start to execute the method[" + methodName + "].");
    }
 
    @Override
    public <E extends MemoryEvent> void onMethodEnd(E event) {
        String methodName = event.getMethodName();
        System.out.println("finished to execute the method[" + methodName + "].");
    }

    @Override
    public <E extends MemoryEvent> void doSomething(E event) {
        String methodName = event.getMethodName();
        System.out.println("do execute the method[" + methodName + "].");
    }
}