package com.nafapap.memory.mgmt.economy.repository.base;

import ma.glasnost.orika.MapperFacade;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: ObjectCopyAdapter </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/11/10 16:30 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public class ObjectCopyAdapter<S, T> implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public MapperFacade getMapperFacade() {
        return getApplicationContext().getBean(MapperFacade.class);
    }

    public List<T> mapAsList(List<S> sources, Class<T> clazz) {
        return getMapperFacade().mapAsList(sources, clazz);
    }

    //public List<T> mapAsList(List<S> sources) {
    //    return getMapperFacade().mapAsList(sources, clazz);
    //}
    //
    //public T toVO(S source) {
    //    return getMapperFacade().map(source, clazz);
    //}

    public T toVO(S source, Class<T> clazz) {
        return getMapperFacade().map(source, clazz);
    }

}
