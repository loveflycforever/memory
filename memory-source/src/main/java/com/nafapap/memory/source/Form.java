package com.nafapap.memory.source;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>Project: memory </p>
 * <p>Name: Form </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/22 11:07 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Form extends BasisEntity {

    private String serialNo;

    /**
     * 创建人
     */
    private String creatorId;
    private String creatorName;
}
