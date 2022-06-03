package com.nafapap.memory.mgmt.economy.repository;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.source.entity.FactumEntity;
import com.nafapap.memory.source.entity.FormatEntity;
import com.nafapap.memory.source.mapper.FactumMapper;
import com.nafapap.memory.source.mapper.FormatMapper;
import com.nafapap.memory.source.wrapper.FactumQuery;
import com.nafapap.memory.source.wrapper.FormatQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: FormatRepository </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/3 22:11 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Component
@RequiredArgsConstructor
public class FormatRepository {

    private final FormatMapper fmFormatMapper;

    public List<FormatEntity> select(PageDto dto) {
        StdPagedList<FormatEntity> list = fmFormatMapper.stdPagedEntity(new FormatQuery()
                .where.deleteFlag().isFalse().end()
                .orderBy.id().asc().end()
                .limit(dto.gainFrom(), dto.gainLimit())
        );

        return list.getData();
    }

    public Long insert(FormatEntity entity) {
        return fmFormatMapper.save(entity);
    }
}
