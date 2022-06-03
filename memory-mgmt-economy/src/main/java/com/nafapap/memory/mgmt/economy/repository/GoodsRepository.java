package com.nafapap.memory.mgmt.economy.repository;

import com.nafapap.memory.source.mapper.FactumMapper;
import com.nafapap.memory.source.mapper.GoodsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
}
