package com.nafapap.memory.support.web;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <p>Project: memory </p>
 * <p>Name: ResponseCodeEnum </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/24 15:57 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Getter
@RequiredArgsConstructor
public enum ResponseCode {

    /**
     * 枚举
     */
    RP_000000("000000", "执行成功", Boolean.TRUE),
    RP_000001("000001", "系统异常", Boolean.FALSE),
    RP_000002("000002", "参数异常", Boolean.FALSE),
    RP_000003("000003", "访问受限", Boolean.FALSE);

    private final String code;
    private final String desc;
    private final Boolean succ;
}
