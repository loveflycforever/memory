package com.nafapap.memory.source;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>Project: memory </p>
 * <p>Name: Log </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/22 11:06 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Log extends BasisEntity {

    private String serialNo;

}
