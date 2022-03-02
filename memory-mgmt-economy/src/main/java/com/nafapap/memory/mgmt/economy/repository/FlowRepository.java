package com.nafapap.memory.mgmt.economy.repository;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.nafapap.memory.mgmt.economy.trans.PageDto;
import com.nafapap.memory.source.dao.intf.FlowDao;
import com.nafapap.memory.source.entity.FlowEntity;
import com.nafapap.memory.source.mapper.FlowMapper;
import com.nafapap.memory.source.wrapper.FlowQuery;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
@Service
public class FlowRepository {

    private final FlowDao flowDao;
    private final FlowMapper flowMapper;

    @Autowired
    public FlowRepository(FlowDao flowDao, FlowMapper flowMapper) {
        this.flowDao = flowDao;
        this.flowMapper = flowMapper;
    }

    public List<FlowEntity> select(PageDto dto) {
        int limit = NumberUtils.max(NumberUtils.INTEGER_ONE, dto.getSize());

        int from = (NumberUtils.max(NumberUtils.INTEGER_ONE, dto.getNumber()) - NumberUtils.INTEGER_ONE) * limit;

        StdPagedList<FlowEntity> list = flowMapper.stdPagedEntity(new FlowQuery()
                .orderBy.id().asc().end()
                .limit(from, limit)
        );

        return list.getData();
    }
}
