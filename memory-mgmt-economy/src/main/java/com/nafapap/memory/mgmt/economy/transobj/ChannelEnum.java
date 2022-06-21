package com.nafapap.memory.mgmt.economy.transobj;

import lombok.Getter;

/**
 * <p>Project: memory </p>
 * <p>Name: ChannelEnum </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/19 15:06 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public enum ChannelEnum {

    /**
     *
     */
    SHOP("店付"), PDD("拼多多"), TAO("淘宝"), DEF("DEF");

    @Getter
    private final String value;

    ChannelEnum(String value) {
        this.value = value;
    }
}
