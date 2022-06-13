package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.mgmt.economy.repository.SubjectRepository;
import com.nafapap.memory.mgmt.economy.repository.TicketRepository;
import com.nafapap.memory.mgmt.economy.service.TicketService;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.TicketRequestDto;
import com.nafapap.memory.source.entity.TicketEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: TicketServiceImpl </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/13 23:51 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public List<TicketEntity> exhibit(PageDto dto) {
        return null;
    }

    @Override
    public TicketEntity create(TicketRequestDto dto) {
        return null;
    }
}
