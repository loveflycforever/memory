package com.nafapap.memory.mgmt.economy.controller;

import com.nafapap.memory.mgmt.economy.service.BridgeService;
import com.nafapap.memory.mgmt.economy.service.FormService;
import com.nafapap.memory.source.entity.FormEntity;
import com.nafapap.memory.mgmt.economy.trans.PageDto;
import com.nafapap.memory.mgmt.economy.trans.RequestDto;
import com.nafapap.memory.mgmt.economy.service.FlowService;
import com.nafapap.memory.source.entity.FlowEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    private final FlowService flowService;
    private final FormService formService;
    private final BridgeService bridgeService;

    @Autowired
    public BillController(FlowService flowService,
                          FormService formService,
                          BridgeService bridgeService) {
        this.flowService = flowService;
        this.formService = formService;
        this.bridgeService = bridgeService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/exhibit")
    public String exhibit(PageDto dto) {
        return String.format("Hello %s!", "");
    }




    @PostMapping("/create")
    public String create(@RequestBody RequestDto dto) {
        FlowEntity flow = flowService.createFlow();
        String flowNo = flow.getSerialNo();

        FormEntity form = formService.createForm(dto);
        String formNo = form.getSerialNo();

        bridgeService.join(formNo, flowNo);

        return String.format("Hello %s!", "");
    }

    @PostMapping("/ensure")
    public String ensure(@RequestBody RequestDto dto) {

        String takingNo = dto.getTakingNo();
        String operator = dto.getOperator();
        String userToken = dto.getUserToken();
        flowService.ensure(takingNo, operator, userToken);

        return null;
    }




}
