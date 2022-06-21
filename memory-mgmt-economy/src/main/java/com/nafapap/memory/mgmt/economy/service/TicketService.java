package com.nafapap.memory.mgmt.economy.service;

import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.TicketRequestDto;
import com.nafapap.memory.mgmt.economy.transobj.TicketVO;
import com.nafapap.memory.source.entity.TicketEntity;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: TicketService </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/13 23:50 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public interface TicketService {
    List<TicketVO> exhibit(PageDto dto);

    TicketEntity create(TicketRequestDto dto);
}
