package com.nafapap.memory.mgmt.economy.repository;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.source.entity.FlowEntity;
import com.nafapap.memory.source.entity.FormEntity;
import com.nafapap.memory.source.mapper.FlowMapper;
import com.nafapap.memory.source.mapper.FormMapper;
import com.nafapap.memory.source.wrapper.FlowQuery;
import com.nafapap.memory.source.wrapper.FormQuery;
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

    private final FormMapper fmFormMapper;
    private final FlowMapper fmFlowMapper;

    public List<FlowEntity> selectFlows(PageDto dto) {
        StdPagedList<FlowEntity> list = fmFlowMapper.stdPagedEntity(new FlowQuery()
                .where.deleteFlag().isFalse().end()
                .orderBy.id().asc().end()
                .limit(dto.getFrom(), dto.getLimit())
        );

        return list.getData();
    }

    public List<FormEntity> selectForms(PageDto dto) {
        StdPagedList<FormEntity> list = fmFormMapper.stdPagedEntity(new FormQuery()
                .where.deleteFlag().isFalse().end()
                .orderBy.id().asc().end()
                .limit(dto.getFrom(), dto.getLimit())
        );

        return list.getData();
    }

    public Long insertFlow(FlowEntity flow) {
        return fmFlowMapper.save(flow);
    }

    public Long insertForm(FormEntity form) {
        return fmFormMapper.save(form);
    }

    public FlowEntity selectFlowBySerialNo(String serialNo) {
        FlowQuery query = FlowQuery.query()
                .where()
                .serialNo().eq(serialNo)
                .end();
        return fmFlowMapper.findOne(query);
    }

    public FormEntity selectFormBySerialNo(String serialNo) {
        FormQuery query = FormQuery.query()
                .where()
                .serialNo().eq(serialNo)
                .end();
        return fmFormMapper.findOne(query);
    }

    public void update(FormEntity update) {
        fmFormMapper.updateById(update);
    }
}
