package com.nafapap.memory.mgmt.economy.transobj;

import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>Project: memory </p>
 * <p>Name: TicketRequestDto </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/13 23:51 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Data
public class TicketRequestDto {

    private String name;
    private String summary;
    private String purchaseLocation;
    private String purchaseDatetime;
    private BigDecimal price;
    private BigDecimal expense;
    private String currency;
    private String channel;
    private String payment;
    private String forward;
}
