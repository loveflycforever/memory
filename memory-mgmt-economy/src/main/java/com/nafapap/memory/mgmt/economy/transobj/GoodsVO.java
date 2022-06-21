package com.nafapap.memory.mgmt.economy.transobj;

import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>Project: memory </p>
 * <p>Name: GoodsVO </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/21 22:37 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Data
public class GoodsVO {

    private Long id;

    private String xThing;

    private String brand;

    private String name;

    private String summary;

    private BigDecimal unitPrice;

    private String unitSpec;

    private String productionDate;

    private String expirationDate;

    private Integer validationTerm;

    private String validationUnit;

    private String barcode;

    private String serialNo;

}
