package com.nafapap.memory.mgmt.economy.controller;

import com.nafapap.memory.mgmt.economy.service.BillService;
import com.nafapap.memory.mgmt.economy.trans.PageDto;
import com.nafapap.memory.mgmt.economy.trans.RequestDto;
import com.nafapap.memory.source.entity.FlowEntity;
import com.nafapap.memory.source.entity.FormEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/exhibit")
    public Object exhibit(PageDto dto) {

        return billService.showFlows(dto);
    }

    @PostMapping("/create")
    public String create(@RequestBody RequestDto dto) {
        FlowEntity flow = billService.createFlow();
        String flowNo = flow.getSerialNo();

        FormEntity form = billService.createForm(dto);
        String formNo = form.getSerialNo();

        billService.join(formNo, flowNo);

        return String.format("Hello %s!", "");
    }

    @PostMapping("/ensure")
    public String ensure(@RequestBody RequestDto dto) {

        String takingNo = dto.getTakingNo();
        String operator = dto.getOperator();
        String userToken = dto.getUserToken();
        billService.ensure(takingNo, operator, userToken);

        return null;
    }




}
