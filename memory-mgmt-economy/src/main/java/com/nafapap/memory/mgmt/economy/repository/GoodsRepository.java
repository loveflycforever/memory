package com.nafapap.memory.mgmt.economy.repository;

import cn.org.atool.fluent.mybatis.model.StdPagedList;
import com.nafapap.memory.mgmt.economy.transobj.GoodsVO;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.ThingVO;
import com.nafapap.memory.source.entity.GoodsEntity;
import com.nafapap.memory.source.helper.GoodsSegment;
import com.nafapap.memory.source.mapper.GoodsMapper;
import com.nafapap.memory.source.wrapper.GoodsQuery;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: GoodsRepository </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/6/3 22:11 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Component
@RequiredArgsConstructor
public class GoodsRepository {

    private final GoodsMapper fmGoodsMapper;

    private final MapperFacade mapperFacade;

    public List<GoodsVO> select(PageDto dto) {
        GoodsSegment.QueryWhere queryWhere = new GoodsQuery().where.deleteFlag().isFalse();
        if(StringUtils.isNotBlank(dto.getTakingNo())) {
            queryWhere.and.serialNo().eq(dto.getTakingNo());
        }
        GoodsQuery query = queryWhere.end();
        StdPagedList<GoodsEntity> list = fmGoodsMapper.stdPagedEntity(
                query.orderBy.id().desc().end()
                        .limit(dto.gainFrom(), dto.gainLimit())
        );

        List<GoodsEntity> data = list.getData();
        List<GoodsVO> result = mapperFacade.mapAsList(data, GoodsVO.class);

        return result;
    }

    public Long insert(GoodsEntity entity) {
        return fmGoodsMapper.save(entity);
    }
}
