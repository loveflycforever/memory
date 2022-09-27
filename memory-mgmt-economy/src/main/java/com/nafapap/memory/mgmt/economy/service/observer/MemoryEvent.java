package com.nafapap.memory.mgmt.economy.service.observer;

import java.util.EventObject;

/**
 * @author PapaFan
 */
public class MemoryEvent extends EventObject {

    private String methodName;

    public MemoryEvent(Object source, String methodName) {
        super(source);
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}