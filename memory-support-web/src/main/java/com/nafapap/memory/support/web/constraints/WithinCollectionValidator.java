package com.nafapap.memory.support.web.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;

/**
 * <p>Project: memory </p>
 * <p>Name: WithinCollectionValidator </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/24 14:20 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public class WithinCollectionValidator implements ConstraintValidator<Within, Collection<String>> {

    Class<?>[] clazz;

    @Override
    public void initialize(Within constraintAnnotation) {
        this.clazz = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Collection<String> value, ConstraintValidatorContext context) {
        if (clazz.length <= 0 || value == null || value.isEmpty()) {
            return true;
        }

        for (Class<?> clz : clazz) {
            try {
                if (clz.isEnum()) {
                    Object[] enumConstants = clz.getEnumConstants();
                    Method method = clz.getMethod("name");
                    HashSet<String> names = new HashSet<>();
                    for (Object object : enumConstants) {
                        Object name = method.invoke(object);
                        names.add(String.valueOf(name));
                    }

                    boolean b = true;
                    for (String v : value) {
                        if (!names.contains(v)) {
                            b = false;
                            break;
                        }
                    }

                    return b;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}