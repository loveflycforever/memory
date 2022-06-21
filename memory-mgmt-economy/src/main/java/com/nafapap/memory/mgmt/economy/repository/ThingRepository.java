package com.nafapap.memory.mgmt.economy.repository;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.ThingPageDto;
import com.nafapap.memory.source.entity.ThingEntity;
import com.nafapap.memory.source.entity.TicketEntity;
import com.nafapap.memory.source.helper.ThingSegment;
import com.nafapap.memory.source.helper.TicketSegment;
import com.nafapap.memory.source.mapper.GoodsMapper;
import com.nafapap.memory.source.mapper.ThingMapper;
import com.nafapap.memory.source.wrapper.ThingQuery;
import com.nafapap.memory.source.wrapper.TicketQuery;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: ThingRepository </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/3 22:11 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Component
@RequiredArgsConstructor
public class ThingRepository {

    private final ThingMapper fmThingMapper;

    public List<ThingEntity> select(ThingPageDto dto) {
        ThingSegment.QueryWhere queryWhere = new ThingQuery().where.deleteFlag().isFalse();
        if(StringUtils.isNotBlank(dto.getTakingNo())) {
            queryWhere.and.serialNo().eq(dto.getTakingNo());
        }
        if(StringUtils.isNotBlank(dto.getName())) {
            queryWhere.and.name().eq(dto.getName());
        }
        ThingQuery query = queryWhere.end();
        StdPagedList<ThingEntity> list = fmThingMapper.stdPagedEntity(
                query.orderBy.id().desc().end()
                        .limit(dto.gainFrom(), dto.gainLimit())
        );

        return list.getData();
    }

    public Long insert(ThingEntity entity) {
        return fmThingMapper.save(entity);
    }
}
