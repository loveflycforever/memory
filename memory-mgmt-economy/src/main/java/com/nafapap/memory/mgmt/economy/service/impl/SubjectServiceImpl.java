package com.nafapap.memory.mgmt.economy.service.impl;

import com.nafapap.memory.mgmt.economy.repository.SubjectRepository;
import com.nafapap.memory.mgmt.economy.service.SerialNoService;
import com.nafapap.memory.mgmt.economy.service.SubjectService;
import com.nafapap.memory.mgmt.economy.transobj.SubjectRequestDto;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.SubjectVO;
import com.nafapap.memory.source.entity.SubjectEntity;
import com.nafapap.memory.support.web.constraints.SerialNo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: SubjectServiceImpl </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/3 21:49 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Service
@RequiredArgsConstructor
@SerialNo(prefix = "sj")
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    private final SerialNoService serialNoService;

    @Override
    public List<SubjectVO> exhibit(PageDto dto) {
        return subjectRepository.select(dto);
    }

    @Override
    public SubjectEntity create(SubjectRequestDto dto) {
        SubjectEntity entity = new SubjectEntity()
                .setSerialNo(serialNoService.generate())
                .setName(dto.getName());
        subjectRepository.insert(entity);
        return entity;
    }
}
