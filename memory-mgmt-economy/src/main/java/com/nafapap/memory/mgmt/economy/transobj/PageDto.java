package com.nafapap.memory.mgmt.economy.transobj;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.math.NumberUtils;

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

    private static final Integer DEFAULT_SIZE = 25;
    private static final Integer DEFAULT_NUMBER = 1;

    /**
     * 分页大小
     */
    private Integer size;

    /**
     * 页码 从 1 开始
     */
    private Integer number;

    public Integer getNumber() {
        return this.number != null && this.number >= DEFAULT_NUMBER ? this.number : DEFAULT_NUMBER;
    }

    public Integer getSize() {
        return this.size != null && this.size >= DEFAULT_NUMBER ? this.size : DEFAULT_SIZE;
    }

    public Integer gainLimit() {
        return NumberUtils.max(DEFAULT_NUMBER, this.getSize());
    }

    public Integer gainFrom() {
        return (NumberUtils.max(DEFAULT_NUMBER, this.getNumber()) - DEFAULT_NUMBER) * gainLimit();
    }
}
