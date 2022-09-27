package com.nafapap.memory.mgmt.economy.service.observer;

import java.util.EventListener;

/**
 * @author PapaFan
 */
public interface MemoryEventListener extends EventListener {

    /**
     * 处理方法开始执行的时候发布的MethodExecutionEvent事件
     * @param event event
     */
    <E extends MemoryEvent> void onMethodBegin(E event);

    /**
     * 处理方法执行将结束时候发布的MethodExecutionEvent事件
     * @param event event
     */
    <E extends MemoryEvent> void onMethodEnd(E event);

    /**
     * 处理方法执行将结束时候发布的MethodExecutionEvent事件
     * @param event event
     */
    <E extends MemoryEvent> void doSomething(E event);
 
}
 
 
