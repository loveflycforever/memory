package com.nafapap.memory.mgmt.economy.repository.base;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: AbstractRepository </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/9/27 15:42 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public abstract class AbstractRepository<E extends IEntity, Q extends IQuery<E>, U extends IUpdate<E>, V>
        extends ObjectCopyAdapter<E, V>
        implements DataAccessible<E> {

    public abstract IWrapperMapper<E, Q, U> getMapper();

    public List<V> select(PageDto dto, Class<V> clazz) {
        return selectVOs(select(dto), clazz);
    }

    @Override
    public E selectByPk(E entity) {
        return getMapper().findById(entity.findPk());
    }

    @Override
    public Long insert(E entity) {
        return getMapper().save(entity);
    }

    @Override
    public void update(E entity) {
        getMapper().updateById(entity);
    }

    private List<V> selectVOs(List<E> data, Class<V> clazz) {
        return mapAsList(data, clazz);
    }
}
