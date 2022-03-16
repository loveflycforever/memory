package com.nafapap.memory.mgmt.economy.repository;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.source.entity.FactumEntity;
import com.nafapap.memory.source.mapper.FactumMapper;
import com.nafapap.memory.source.wrapper.FactumQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: BillRepository </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/24 16:30 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Component
@RequiredArgsConstructor
public class BillRepository {

    private final FactumMapper fmFactumMapper;

    public List<FactumEntity> selectFlows(PageDto dto) {
        StdPagedList<FactumEntity> list = fmFactumMapper.stdPagedEntity(new FactumQuery()
                .where.deleteFlag().isFalse().end()
                .orderBy.id().asc().end()
                .limit(dto.getFrom(), dto.getLimit())
        );

        return list.getData();
    }

    public List<FactumEntity> selectForms(PageDto dto) {
        StdPagedList<FactumEntity> list = fmFactumMapper.stdPagedEntity(new FactumQuery()
                .where.deleteFlag().isFalse().end()
                .orderBy.id().asc().end()
                .limit(dto.getFrom(), dto.getLimit())
        );

        return list.getData();
    }

    public Long insertForm(FactumEntity form) {
        return fmFactumMapper.save(form);
    }

    public FactumEntity selectFormBySerialNo(String serialNo) {
        FactumQuery query = FactumQuery.query()
                .where()
                .serialNo().eq(serialNo)
                .end();
        return fmFactumMapper.findOne(query);
    }

    public void update(FactumEntity update) {
        fmFactumMapper.updateById(update);
    }
}
