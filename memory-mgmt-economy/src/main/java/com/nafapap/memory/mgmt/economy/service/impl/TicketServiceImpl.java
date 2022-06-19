package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.mgmt.economy.repository.SubjectRepository;
import com.nafapap.memory.mgmt.economy.repository.TicketRepository;
import com.nafapap.memory.mgmt.economy.service.TicketService;
import com.nafapap.memory.mgmt.economy.transobj.*;
import com.nafapap.memory.source.entity.SubjectEntity;
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
        return ticketRepository.select(dto);
    }

    @Override
    public TicketEntity create(TicketRequestDto dto) {
        TicketEntity entity = new TicketEntity()
                .setName(dto.getName())
                .setSummary(dto.getSummary())
                .setPurchaseLocation(dto.getPurchaseLocation())
                .setPurchaseDatetime(dto.getPurchaseDatetime())
                .setPrice(dto.getPrice())
                .setExpense(dto.getExpense())
                .setCurrency(CurrencyEnum.valueOf(dto.getCurrency()).name())
                .setChannel(ChannelEnum.valueOf(dto.getChannel()).getValue())
                .setPayment(PaymentEnum.valueOf(dto.getPayment()).getValue())
                .setForward(ForwardEnum.valueOf(dto.getForward()).getValue());
        ticketRepository.insert(entity);
        return entity;
    }
}
