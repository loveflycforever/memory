package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.mgmt.economy.repository.TicketRepository;
import com.nafapap.memory.mgmt.economy.service.SerialNoService;
import com.nafapap.memory.mgmt.economy.service.TicketService;
import com.nafapap.memory.mgmt.economy.service.observer.MemoryEventPublisher4Spring;
import com.nafapap.memory.mgmt.economy.service.observer.TicketEvent;
import com.nafapap.memory.mgmt.economy.transobj.*;
import com.nafapap.memory.source.entity.TicketEntity;
import com.nafapap.memory.support.web.constraints.SerialNo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
@SerialNo(prefix = "tk")
public class TicketServiceImpl extends MemoryEventPublisher4Spring implements TicketService {

    private final TicketRepository ticketRepository;

    private final SerialNoService serialNoService;

    @Override
    public List<TicketVO> exhibit(PageDto dto) {
        return ticketRepository.select(dto, TicketVO.class);
    }

    @Override
    public TicketVO create(TicketRequestDto dto) {
        TicketEntity entity = convert2Entity(dto);
        entity.setStatus(StatusEnum.CONFIRM.name())
                .setSerialNo(serialNoService.generate());
        ticketRepository.insert(entity);
        return ticketRepository.toVO(entity, TicketVO.class);
    }

    @Override
    public TicketVO prepare(TicketRequestDto dto) {
        TicketEntity entity = convert2Entity(dto);
        entity.setStatus(StatusEnum.PREPARE.name())
                .setSerialNo(serialNoService.generate());
        ticketRepository.insert(entity);
        return ticketRepository.toVO(entity, TicketVO.class);
    }

    @Override
    public TicketVO confirm(TicketRequestDto dto) {

        Long rowId = dto.getId();
        TicketEntity ticketEntity = ticketRepository.selectByPk(new TicketEntity());
        //if(ticketEntity)
        TicketEntity entity = new TicketEntity().setId(rowId)
                .setStatus(StatusEnum.CONFIRM.name());
        ticketRepository.update(entity);

        String serialNo = ticketEntity.getSerialNo();
        this.methodToMonitor(serialNo);
        return ticketRepository.toVO(entity, TicketVO.class);
    }

    @Override
    public void methodToMonitor(Object serialNo) {
        TicketEvent ticketEvent = new TicketEvent(serialNo, "");
        publishEvent("", ticketEvent);
    }

    @Override
    public TicketVO cancel(TicketRequestDto dto) {
        return null;
    }

    private TicketEntity convert2Entity(TicketRequestDto dto) {
        return new TicketEntity()
                .setName(dto.getName())
                .setSummary(dto.getSummary())
                .setPurchaseLocation(dto.getPurchaseLocation())
                .setPurchaseDatetime(dto.getPurchaseDatetime())
                .setPrice(dto.getPrice())
                .setExpense(dto.getExpense())
                .setCurrency(CurrencyEnum.valueOf(dto.getCurrency()).name())
                .setChinaYuan(exchange2ChinaYuan(dto))
                .setChannel(ChannelEnum.valueOf(dto.getChannel()).getValue())
                .setPayment(PaymentEnum.valueOf(dto.getPayment()).getValue())
                .setForward(ForwardEnum.valueOf(dto.getForward()).getValue());
    }

    private BigDecimal exchange2ChinaYuan(TicketRequestDto dto) {
        return CurrencyEnum.valueOf(dto.getCurrency()) != CurrencyEnum.CNY ? BigDecimal.ZERO : dto.getExpense();
    }

}
