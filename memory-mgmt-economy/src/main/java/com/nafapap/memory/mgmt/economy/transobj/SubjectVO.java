package com.nafapap.memory.mgmt.economy.transobj;

import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import lombok.Data;

/**
 * <p>Project: memory </p>
 * <p>Name: SubjectVO </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/22 2:47 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Data
public class SubjectVO {

    private Long id;

    private String name;

    private String serialNo;

    private String summary;

}
