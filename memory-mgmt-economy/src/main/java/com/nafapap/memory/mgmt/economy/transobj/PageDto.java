package com.nafapap.memory.mgmt.economy.transobj;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>Project: memory </p>
 * <p>Name: AuthDto </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/23 13:37 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageDto extends AuthDto {

    /**
     * 分页大小
     */
    private Integer size;

    /**
     * 页码 从 1 开始
     */
    private Integer number;
}
