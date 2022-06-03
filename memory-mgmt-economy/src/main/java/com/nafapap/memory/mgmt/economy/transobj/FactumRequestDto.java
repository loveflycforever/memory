package com.nafapap.memory.mgmt.economy.transobj;

import com.nafapap.memory.support.web.constraints.Within;
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
public class FactumRequestDto extends RequestDto {

    @NotBlank
    @Within(message = "类型输入错误",value = FlowFormat.class )
    private String format;

}


