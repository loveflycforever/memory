package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.mgmt.economy.repository.BillRepository;
import com.nafapap.memory.mgmt.economy.repository.FormatRepository;
import com.nafapap.memory.mgmt.economy.service.FormatService;
import com.nafapap.memory.mgmt.economy.transobj.FormatRequestDto;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.RequestDto;
import com.nafapap.memory.source.entity.FactumEntity;
import com.nafapap.memory.source.entity.FormatEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: FormatService </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/3 21:49 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Service
@RequiredArgsConstructor
public class FormatServiceImpl implements FormatService {

    private final FormatRepository formatRepository;

    @Override
    public List<FormatEntity> exhibit(PageDto dto) {
        return formatRepository.select(dto);
    }

    @Override
    public FormatEntity create(FormatRequestDto dto) {
        FormatEntity entity = new FormatEntity()
                .setName(dto.getName());
        Long id = formatRepository.insert(entity);
        entity.setId(id);
        return entity;
    }
}