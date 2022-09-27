package com.nafapap.memory.commons.tools;

/**
 * <p>Project: memory </p>
 * <p>Name: UncheckedUtils </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/9/28 9:08 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public class UncheckedUtils {

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj) {
        return (T) obj;
    }
}
