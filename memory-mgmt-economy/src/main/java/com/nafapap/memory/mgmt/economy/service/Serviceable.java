package com.nafapap.memory.mgmt.economy.service;

import com.nafapap.memory.mgmt.economy.transobj.PageDto;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: Serviceable </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/9/27 14:22 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public interface Serviceable<D, V> {
    List<V> exhibit(PageDto dto);

    V create(D dto);

    V prepare(D dto);

    V confirm(D dto);

    V cancel(D dto);
}
