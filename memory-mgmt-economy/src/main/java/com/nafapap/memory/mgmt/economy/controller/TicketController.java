package com.nafapap.memory.mgmt.economy.controller;

import com.nafapap.memory.mgmt.economy.service.TicketService;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.TicketRequestDto;
import com.nafapap.memory.source.entity.TicketEntity;
import com.nafapap.memory.support.web.ResponseView;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@Api(tags = "TicketController")
@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/exhibit")
    public Object exhibit(PageDto dto) {
        List<TicketEntity> entities = ticketService.exhibit(dto);
        return ResponseView.build(entities);
    }

    @PostMapping("/create")
    public ResponseView create(@RequestBody @Validated TicketRequestDto dto) {
        TicketEntity entity = ticketService.create(dto);
        return ResponseView.build(entity);
    }
}
