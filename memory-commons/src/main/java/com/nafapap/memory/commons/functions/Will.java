package com.nafapap.memory.commons.functions;

import java.util.Objects;
import java.util.function.Function;

/**
 * <p>Project: memory </p>
 * <p>Name: Will </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/24 15:49 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@FunctionalInterface
public interface Will<T, R> {

    R will(T t);

    default <V> Function<T, V> with(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);

        return (T t) -> after.apply(will(t));
    }
}


