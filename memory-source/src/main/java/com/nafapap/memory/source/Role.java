package com.nafapap.memory.source;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>Project: memory </p>
 * <p>Name: Role </p>
 * <p>Description: 角色 </p>
 * <p>Date: 2022/2/22 11:15 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Role extends BasisEntity {

    /**
     * 角色等级
     */
    private Integer grade;

    /**
     * 角色称号
     */
    private String label;
}
