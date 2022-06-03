package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.mgmt.economy.service.ThingService;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.RequestDto;
import com.nafapap.memory.source.entity.ThingEntity;
import lombok.RequiredArgsConstructor;
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
public class ThingServiceImpl implements ThingService {
    @Override
    public List<ThingEntity> exhibit(PageDto dto) {
        return null;
    }

    @Override
    public ThingEntity create(RequestDto dto) {
        return null;
    }
}
