package com.nafapap.memory.mgmt.economy.controller;

import com.nafapap.memory.source.Form;
import com.nafapap.memory.mgmt.economy.data.AuthDto;
import com.nafapap.memory.mgmt.economy.data.PageDto;
import com.nafapap.memory.mgmt.economy.data.RequestDto;
import com.nafapap.memory.mgmt.economy.service.BillService;
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

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
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
    public String create(@RequestBody AuthDto dto) {
        FlowEntity flow = billService.createFlow();
        String flowNo = flow.getSerialNo();
        Form form = billService.createForm(flowNo);
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
