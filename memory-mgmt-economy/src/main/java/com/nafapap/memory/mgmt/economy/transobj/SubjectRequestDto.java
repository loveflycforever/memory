package com.nafapap.memory.mgmt.economy.transobj;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>Project: memory </p>
 * <p>Name: SubjectRequestDto </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/24 14:20 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SubjectRequestDto extends RequestDto {

    private String name;

    private String text;
}


