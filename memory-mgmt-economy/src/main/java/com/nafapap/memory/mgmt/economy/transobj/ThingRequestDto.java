package com.nafapap.memory.mgmt.economy.transobj;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>Project: memory </p>
 * <p>Name: ProcureRequestDto </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/3 23:29 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ThingRequestDto extends AuthDto {

    private String belongSerialNo;
    private String name;
    private String summary;
    private String symbol;
}
