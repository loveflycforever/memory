package com.nafapap.memory.mgmt.economy.transobj;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>Project: memory </p>
 * <p>Name: ThingPageDto </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/21 20:55 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ThingPageDto extends PageDto {

    private String name;
}
