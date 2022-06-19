package com.nafapap.memory.mgmt.economy.transobj;

import lombok.Getter;

/**
 * <p>Project: memory </p>
 * <p>Name: PaymentEnum </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/19 13:39 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public enum PaymentEnum {

    /**
     *
     */
    HUA_BEI("蚂蚁花呗"),WX_PAY("微信支付");

    @Getter
    private final String value;

    PaymentEnum(String value) {
        this.value = value;
    }
}
