package com.nafapap.memory.mgmt.economy.controller;

import com.nafapap.memory.mgmt.economy.service.BillService;
import com.nafapap.memory.mgmt.economy.transobj.FactumRequestDto;
import com.nafapap.memory.mgmt.economy.transobj.FlowFormat;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.RequestDto;
import com.nafapap.memory.source.entity.FactumEntity;
import com.nafapap.memory.support.web.ResponseView;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: BillController </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/23 13:27 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Api(tags = "表单接口")
@RestController
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @GetMapping("/exhibit")
    public Object exhibit(PageDto dto) {
        List<FactumEntity> entities = billService.showForm(dto);
        return ResponseView.build(entities);
    }

    @PostMapping("/create")
    public ResponseView create(@RequestBody @Validated FactumRequestDto dto) {
        String flowNo = null;

        if (StringUtils.equalsIgnoreCase(dto.getFormat(), FlowFormat.SAVE.name())
                || StringUtils.equalsIgnoreCase(dto.getFormat(), FlowFormat.COST.name())) {
            FactumEntity flow = billService.createForm(dto);
            flowNo = flow.getSerialNo();
        }

        if(StringUtils.equalsIgnoreCase(dto.getFormat(), FlowFormat.SAVE.name())
                || StringUtils.equalsIgnoreCase(dto.getFormat(), FlowFormat.COST.name())) {
            dto.setFormat(FlowFormat.REQUEST.name());
        }

        if (NumberUtils.INTEGER_ONE == 1) {
            FactumEntity form = billService.createForm(dto);
            String formNo = form.getSerialNo();
            billService.join(formNo, flowNo);
        }

        if(Boolean.TRUE.equals(dto.getAuto())) {
            dto.setFormat(FlowFormat.EXAMINE.name());
            FactumEntity form = billService.createForm(dto);
            String formNo = form.getSerialNo();
            billService.join(formNo, flowNo);
        }

        return ResponseView.build();
    }

    @PostMapping("/ensure")
    public ResponseView ensure(@RequestBody @Validated RequestDto dto) {

        String takingNo = dto.getTakingNo();
        String operator = dto.getOperator();
        String userToken = dto.getUserToken();
        billService.ensure(takingNo, operator, userToken);

        return ResponseView.build();
    }


}
