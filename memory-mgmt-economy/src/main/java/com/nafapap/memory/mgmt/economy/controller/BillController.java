package com.nafapap.memory.mgmt.economy.controller;

import com.nafapap.memory.mgmt.economy.service.BillService;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.RequestDto;
import com.nafapap.memory.source.entity.FlowEntity;
import com.nafapap.memory.source.entity.FormEntity;
import com.nafapap.memory.support.web.ResponseView;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
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
@Api(tags = "账单接口")
@RestController
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @GetMapping("/exhibit")
    public Object exhibit(PageDto dto) {
        List<FlowEntity> entities = billService.showFlows(dto);
        return ResponseView.build(entities);
    }

    @GetMapping("/exhibit/expand")
    public Object exhibitExpand(PageDto dto) {
        List<FormEntity> entities = billService.showForm(dto);
        return ResponseView.build(entities);
    }

    @PostMapping("/create")
    public ResponseView create(@RequestBody RequestDto dto) {
        FlowEntity flow = billService.createFlow();
        String flowNo = flow.getSerialNo();

        FormEntity form = billService.createForm(dto);
        String formNo = form.getSerialNo();

        billService.join(formNo, flowNo);

        return ResponseView.build();
    }

    @PostMapping("/ensure")
    public ResponseView ensure(@RequestBody RequestDto dto) {

        String takingNo = dto.getTakingNo();
        String operator = dto.getOperator();
        String userToken = dto.getUserToken();
        billService.ensure(takingNo, operator, userToken);

        return ResponseView.build();
    }




}
