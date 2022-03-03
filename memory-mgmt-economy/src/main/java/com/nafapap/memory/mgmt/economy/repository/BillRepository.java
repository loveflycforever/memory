package com.nafapap.memory.mgmt.economy.repository;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.nafapap.memory.mgmt.economy.trans.PageDto;
import com.nafapap.memory.source.entity.FlowEntity;
import com.nafapap.memory.source.entity.FormEntity;
import com.nafapap.memory.source.mapper.FlowMapper;
import com.nafapap.memory.source.mapper.FormMapper;
import com.nafapap.memory.source.wrapper.FlowQuery;
import com.nafapap.memory.source.wrapper.FormQuery;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * <p>Project: memory </p>
 * <p>Name: FlowMapper </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/24 16:30 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Component
public class BillRepository {

    private final FormMapper formMapper;
    private final FlowMapper flowMapper;

    @Autowired
    public BillRepository(FormMapper formMapper, FlowMapper flowMapper) {
        this.formMapper = formMapper;
        this.flowMapper = flowMapper;
    }

    public List<FlowEntity> selectFlows(PageDto dto) {
        int limit = NumberUtils.max(NumberUtils.INTEGER_ONE, dto.getSize());

        int from = (NumberUtils.max(NumberUtils.INTEGER_ONE, dto.getNumber()) - NumberUtils.INTEGER_ONE) * limit;

        StdPagedList<FlowEntity> list = flowMapper.stdPagedEntity(new FlowQuery()
                .orderBy.id().asc().end()
                .limit(from, limit)
        );

        return list.getData();
    }

    public List<FormEntity> selectForms(PageDto dto) {
        int limit = NumberUtils.max(NumberUtils.INTEGER_ONE, dto.getSize());

        int from = (NumberUtils.max(NumberUtils.INTEGER_ONE, dto.getNumber()) - NumberUtils.INTEGER_ONE) * limit;

        StdPagedList<FormEntity> list = formMapper.stdPagedEntity(new FlowQuery()
                .orderBy.id().asc().end()
                .limit(from, limit)
        );

        return list.getData();
    }

    public FlowEntity insertFlow(FlowEntity flow) {
        return flowMapper.save(flow);
    }

    public FormEntity insertForm(FormEntity form) {
        return formMapper.save(form);
    }

    public FlowEntity selectFlowBySerialNo(String serialNo) {
        FlowQuery query = FlowQuery.query()
                .where()
                .serialNo().eq(serialNo)
                .end();
        return flowMapper.findOne(query);
    }

    public FormEntity selectFormBySerialNo(String serialNo) {
        FormQuery query = FormQuery.query()
                .where()
                .serialNo().eq(serialNo)
                .end();
        return formMapper.findOne(query);
    }

    public void update(FormEntity update) {
        formMapper.updateById(update);
    }
}
