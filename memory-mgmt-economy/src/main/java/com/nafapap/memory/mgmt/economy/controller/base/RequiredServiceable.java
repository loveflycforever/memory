package com.nafapap.memory.mgmt.economy.controller.base;

import com.nafapap.memory.mgmt.economy.service.Serviceable;

/**
 * <p>Project: memory </p>
 * <p>Name: RequiredServiceable </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/10/28 15:03 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public interface RequiredServiceable<D, V> {

    /**
     * 实际服务
     * @return 实际服务
     */
    Serviceable<D, V> actualService();
}
