package com.nafapap.memory.mgmt.economy.service.observer;

import java.lang.annotation.*;

/**
 *
 * @author PapaFan
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MeListener {

    /**
     * xxx
     * @return xxx
     */
    Class<? extends MemoryEventPublisher>[] publisher();

}
