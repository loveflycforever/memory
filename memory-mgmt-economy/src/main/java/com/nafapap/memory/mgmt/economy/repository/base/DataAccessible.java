package com.nafapap.memory.mgmt.economy.repository.base;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import ma.glasnost.orika.MapperFacade;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: DataAccessible </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/9/27 15:42 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public interface DataAccessible<E> {

    List<E> select(PageDto dto);

    E selectByPk(E entity);

    Long insert(E entity);

    void update(E entity);
}
