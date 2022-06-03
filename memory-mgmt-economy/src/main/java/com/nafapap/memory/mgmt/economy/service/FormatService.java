package com.nafapap.memory.mgmt.economy.service;

import com.nafapap.memory.mgmt.economy.transobj.FormatRequestDto;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.RequestDto;
import com.nafapap.memory.source.entity.FormatEntity;

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
public interface FormatService {
    List<FormatEntity> exhibit(PageDto dto);

    FormatEntity create(FormatRequestDto dto);
}
