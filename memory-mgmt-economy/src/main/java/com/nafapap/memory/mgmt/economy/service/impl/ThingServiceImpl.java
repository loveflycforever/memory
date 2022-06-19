package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.mgmt.economy.repository.ThingRepository;
import com.nafapap.memory.mgmt.economy.repository.TicketRepository;
import com.nafapap.memory.mgmt.economy.service.SerialNoService;
import com.nafapap.memory.mgmt.economy.service.ThingService;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.ThingRequestDto;
import com.nafapap.memory.source.entity.GoodsEntity;
import com.nafapap.memory.source.entity.ThingEntity;
import com.nafapap.memory.support.web.constraints.SerialNo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: ThingService </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/3 21:49 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Service
@RequiredArgsConstructor
@SerialNo(prefix = "tg")
public class ThingServiceImpl implements ThingService {

    private final ThingRepository thingRepository;

    private final SerialNoService serialNoService;

    @Override
    public List<ThingEntity> exhibit(PageDto dto) {
        return thingRepository.select(dto);
    }

    @Override
    public ThingEntity create(ThingRequestDto dto) {

        ThingEntity entity = new ThingEntity()
                .setSerialNo(serialNoService.generate())
                .setName(dto.getName())
                .setSummary(dto.getSummary())
                .setSymbol(dto.getSymbol())
                ;
        thingRepository.insert(entity);
        return entity;
    }
}
