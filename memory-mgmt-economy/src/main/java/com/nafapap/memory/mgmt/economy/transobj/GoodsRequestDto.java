package com.nafapap.memory.mgmt.economy.transobj;

import com.nafapap.memory.support.web.constraints.Within;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * <p>Project: memory </p>
 * <p>Name: RequestDto </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/24 14:20 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsRequestDto extends AuthDto {

    //@NotBlank
    private String belongSerialNo;
    @NotBlank
    private String thingName;
    private String name;
    private String brand;
    private String summary;
    private String productionDate;
    private Integer validationTerm;
    private String validationUnit;
    private String expirationDate;
    private String barcode;
    private BigDecimal unitPrice;
    private String unitSpec;

    public NameString getThingName() {
        return new NameString(thingName);
    }
}


