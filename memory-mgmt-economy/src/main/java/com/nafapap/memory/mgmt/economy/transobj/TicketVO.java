package com.nafapap.memory.mgmt.economy.transobj;

import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>Project: memory </p>
 * <p>Name: TicketVO </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/22 2:44 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Data
public class TicketVO {

    private Long id;

    private String channel;

    private BigDecimal chinaYuan;

    private String currency;

    private BigDecimal expense;

    private String forward;

    private String name;

    private String payment;

    private BigDecimal price;

    private String purchaseDatetime;

    private String purchaseLocation;

    private String serialNo;

    private String summary;

}
