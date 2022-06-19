package com.nafapap.memory.mgmt.economy.transobj;

import lombok.Getter;

/**
 * <p>Project: memory </p>
 * <p>Name: ForwardEnum </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/19 15:04 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public enum ForwardEnum {

    /**
     *
     */
    PRE("预付款"), DIR("直接付款");
    @Getter
    private final String value;

    ForwardEnum(String value) {
        this.value = value;
    }
}
