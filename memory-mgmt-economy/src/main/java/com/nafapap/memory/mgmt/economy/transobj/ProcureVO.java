package com.nafapap.memory.mgmt.economy.transobj;

import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>Project: memory </p>
 * <p>Name: ProcureVO </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/22 2:46 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Data
public class ProcureVO {

    private Long id;

    private Integer actualDay;

    private BigDecimal chinaYuan;

    private String closedDate;

    private String currency;

    private BigDecimal hold;

    private Integer planDay;

    private BigDecimal price;

    private String purchaseDatetime;

    private String purchaseLocation;

    private BigDecimal purchaseQuantity;

    private String purchaseSpecific;

    private String serialNo;

    private String summary;

    private String unit;

    private String xGoods;

}
