package com.nafapap.memory.mgmt.economy.repository;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.SubjectVO;
import com.nafapap.memory.mgmt.economy.transobj.TicketVO;
import com.nafapap.memory.source.entity.SubjectEntity;
import com.nafapap.memory.source.mapper.SubjectMapper;
import com.nafapap.memory.source.wrapper.SubjectQuery;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: SubjectRepository </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/3 22:11 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Component
@RequiredArgsConstructor
public class SubjectRepository {

    private final SubjectMapper fmSubjectMapper;

    private final MapperFacade mapperFacade;

    public List<SubjectVO> select(PageDto dto) {
        StdPagedList<SubjectEntity> list = fmSubjectMapper.stdPagedEntity(new SubjectQuery()
                .where.deleteFlag().isFalse().end()
                .orderBy.id().asc().end()
                .limit(dto.gainFrom(), dto.gainLimit())
        );

        List<SubjectEntity> data = list.getData();
        List<SubjectVO> result = mapperFacade.mapAsList(data, SubjectVO.class);

        return result;
    }

    public Long insert(SubjectEntity entity) {
        return fmSubjectMapper.save(entity);
    }
}
