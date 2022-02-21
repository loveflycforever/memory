package com.nafapap.memory.source;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>Project: memory </p>
 * <p>Name: User </p>
 * <p>Description: 用户 </p>
 * <p>Date: 2022/2/22 11:15 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BasisEntity {

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户-角色等级
     */
    private Integer roleGrade;
}
