package com.nafapap.memory.mgmt.economy.service.observer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * <p>Project: memory </p>
 * <p>Name: MemoryEventPublisher4Spring </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/10/28 16:04 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public class MemoryEventPublisher4Spring extends MemoryEventPublisher implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(MeListener.class)) {
            MeListener annotation = bean.getClass().getAnnotation(MeListener.class);
            for (Class<? extends MemoryEventPublisher> aClass : annotation.publisher()) {
                if (this.getClass() == aClass) {
                    this.addListener((MemoryEventListener) bean);
                }
            }
        }
        return bean;
    }
}
