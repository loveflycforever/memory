package com.nafapap.memory.mgmt.economy.transobj;

import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import lombok.Data;

/**
 * <p>Project: memory </p>
 * <p>Name: ThingVO </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/21 22:22 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Data
public class ThingVO {

    private Long id;

    private String name;

    private String summary;

    private String symbol;

    private String serialNo;

}
