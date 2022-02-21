package com.nafapap.memory.mgmt.economy.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>Project: memory </p>
 * <p>Name: RequestDto </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/24 14:20 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RequestDto extends AuthDto {

    /**
     * 单号
     */
    @NotBlank
    private String takingNo;

    /**
     * 操作符
     */
    @NotBlank
    private String operator;

}


