package com.nafapap.memory.mgmt.economy.repository;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.source.entity.TicketEntity;
import com.nafapap.memory.source.helper.TicketSegment;
import com.nafapap.memory.source.mapper.TicketMapper;
import com.nafapap.memory.source.wrapper.TicketQuery;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: TicketRepository </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/13 23:52 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Component
@RequiredArgsConstructor
public class TicketRepository {
    private final TicketMapper fmTicketMapper;

    public List<TicketEntity> select(PageDto dto) {
        TicketSegment.QueryWhere queryWhere = new TicketQuery().where.deleteFlag().isFalse();
        if(StringUtils.isNotBlank(dto.getTakingNo())) {
            queryWhere.and.serialNo().eq(dto.getTakingNo());
        }
        TicketQuery query = queryWhere.end();
        StdPagedList<TicketEntity> list = fmTicketMapper.stdPagedEntity(
                query.orderBy.purchaseDatetime().desc().end()
                .limit(dto.gainFrom(), dto.gainLimit())
        );

        return list.getData();
    }

    public Long insert(TicketEntity entity) {
        return fmTicketMapper.save(entity);
    }

}
