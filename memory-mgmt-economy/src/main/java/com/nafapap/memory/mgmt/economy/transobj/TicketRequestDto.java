package com.nafapap.memory.mgmt.economy.transobj;

import com.nafapap.memory.support.web.constraints.Within;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(callSuper = true)
@Data
public class TicketRequestDto extends AuthDto {

    private Long id;
    private String name;
    private String summary;
    private String purchaseLocation;
    private String purchaseDatetime;
    private BigDecimal price;
    private BigDecimal expense;
    @Within(message = "类型输入错误",value = CurrencyEnum.class )
    private String currency;
    @Within(message = "类型输入错误",value = ChannelEnum.class )
    private String channel;
    @Within(message = "类型输入错误",value = PaymentEnum.class )
    private String payment;
    @Within(message = "类型输入错误",value = ForwardEnum.class )
    private String forward;
}
