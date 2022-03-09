package com.nafapap.memory.support.web.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

/**
 * <p>Project: memory </p>
 * <p>Name: WithinValidator </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/24 14:20 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public class WithinValidator implements ConstraintValidator<Within, String> {

    Class<?>[] clazz;

    @Override
    public void initialize(Within constraintAnnotation) {
        this.clazz = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (clazz.length <= 0 || value == null) {
            return true;
        }

        for (Class<?> clz : clazz) {
            try {
                if (clz.isEnum()) {
                    Object[] enumConstants = clz.getEnumConstants();
                    Method method = clz.getMethod("name");
                    for (Object object : enumConstants) {
                        Object name = method.invoke(object);
                        if (value.equals(String.valueOf(name))) {
                            return true;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}