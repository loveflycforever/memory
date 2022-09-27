package com.nafapap.memory.mgmt.economy.controller;

import com.nafapap.memory.mgmt.economy.controller.base.AbstractController;
import com.nafapap.memory.mgmt.economy.service.GoodsService;
import com.nafapap.memory.mgmt.economy.transobj.GoodsRequestDto;
import com.nafapap.memory.mgmt.economy.transobj.GoodsVO;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Project: memory </p>
 * <p>Name: GoodsController </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/23 13:27 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Api(tags = "GoodsController")
@RestController
@RequiredArgsConstructor
@RequestMapping("/goods")
public class GoodsController extends AbstractController<GoodsRequestDto, GoodsVO> {

    private final GoodsService goodsService;

    @Override
    public GoodsService actualService() {
        return goodsService;
    }

}
