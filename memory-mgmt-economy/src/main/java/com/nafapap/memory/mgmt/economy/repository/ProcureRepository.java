package com.nafapap.memory.mgmt.economy.repository;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.ProcureVO;
import com.nafapap.memory.mgmt.economy.transobj.TicketVO;
import com.nafapap.memory.source.entity.GoodsEntity;
import com.nafapap.memory.source.entity.ProcureEntity;
import com.nafapap.memory.source.helper.GoodsSegment;
import com.nafapap.memory.source.helper.ProcureSegment;
import com.nafapap.memory.source.mapper.GoodsMapper;
import com.nafapap.memory.source.mapper.ProcureMapper;
import com.nafapap.memory.source.wrapper.GoodsQuery;
import com.nafapap.memory.source.wrapper.ProcureQuery;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: ProcureRepository </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/3 22:11 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Component
@RequiredArgsConstructor
public class ProcureRepository {

    private final ProcureMapper fmProcureMapper;

    private final MapperFacade mapperFacade;

    public List<ProcureVO> select(PageDto dto) {
        ProcureSegment.QueryWhere queryWhere = new ProcureQuery().where.deleteFlag().isFalse();
        if(StringUtils.isNotBlank(dto.getTakingNo())) {
            queryWhere.and.serialNo().eq(dto.getTakingNo());
        }
        ProcureQuery query = queryWhere.end();
        StdPagedList<ProcureEntity> list = fmProcureMapper.stdPagedEntity(
                query.orderBy.id().desc().end()
                        .limit(dto.gainFrom(), dto.gainLimit())
        );

        List<ProcureEntity> data = list.getData();
        List<ProcureVO> result = mapperFacade.mapAsList(data, ProcureVO.class);

        return result;
    }

    public Long insert(ProcureEntity entity) {
        return fmProcureMapper.save(entity);
    }
}
