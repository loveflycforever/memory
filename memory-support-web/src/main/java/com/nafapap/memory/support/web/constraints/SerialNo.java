package com.nafapap.memory.support.web.constraints;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * <p>Project: memory </p>
 * <p>Name: SerialNo </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/19 16:07 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SerialNo {
    String prefix();
}
