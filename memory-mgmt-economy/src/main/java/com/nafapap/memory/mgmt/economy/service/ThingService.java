package com.nafapap.memory.mgmt.economy.service;

import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.ThingPageDto;
import com.nafapap.memory.mgmt.economy.transobj.ThingRequestDto;
import com.nafapap.memory.mgmt.economy.transobj.ThingVO;
import com.nafapap.memory.source.entity.ThingEntity;

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
public interface ThingService {
    List<ThingVO> exhibit(ThingPageDto dto);

    ThingEntity create(ThingRequestDto dto);
}
