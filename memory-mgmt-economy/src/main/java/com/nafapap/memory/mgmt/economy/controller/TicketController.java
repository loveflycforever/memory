package com.nafapap.memory.mgmt.economy.controller;

import com.nafapap.memory.mgmt.economy.controller.base.AbstractController;
import com.nafapap.memory.mgmt.economy.service.TicketService;
import com.nafapap.memory.mgmt.economy.transobj.TicketRequestDto;
import com.nafapap.memory.mgmt.economy.transobj.TicketVO;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Project: memory </p>
 * <p>Name: TicketController </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/13 23:49 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Api(tags = "小票接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketController extends AbstractController<TicketRequestDto, TicketVO> {

    private final TicketService ticketService;

    @Override
    public TicketService actualService() {
        return ticketService;
    }

}
