package com.nafapap.memory.mgmt.economy.service;

import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.ProcureRequestDto;
import com.nafapap.memory.source.entity.ProcureEntity;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: ProcureService </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/3 21:49 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public interface ProcureService {
    List<ProcureEntity> exhibit(PageDto dto);

    ProcureEntity create(ProcureRequestDto dto);
}
