package com.nafapap.memory.mgmt.economy.transobj;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * <p>Project: memory </p>
 * <p>Name: ProcureRequestDto </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/3 23:29 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProcureRequestDto extends AuthDto {

    @NotBlank
    private String belongSerialNo;


    private String summary;
    private Integer purchaseQuantity;
    private String purchaseLocation;
    private String purchaseDatetime;
    private BigDecimal price;
    private String currency;
    private BigDecimal chinaYuan;
    private Integer hold;
    private String unit;
    private Integer planDay;
    private String closedDate;
    private Integer actualDay;
}