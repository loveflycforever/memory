package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.mgmt.economy.service.ProcureService;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.RequestDto;
import com.nafapap.memory.source.entity.ProcureEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
@Service
@RequiredArgsConstructor
public class ProcureServiceImpl implements ProcureService {
    @Override
    public List<ProcureEntity> exhibit(PageDto dto) {
        return null;
    }

    @Override
    public ProcureEntity create(RequestDto dto) {
        return null;
    }
}
