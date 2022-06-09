package com.nafapap.memory.mgmt.economy.controller;

import com.nafapap.memory.mgmt.economy.service.GoodsService;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.RequestDto;
import com.nafapap.memory.source.entity.GoodsEntity;
import com.nafapap.memory.support.web.ResponseView;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@Api(tags = "每日接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/goods")
public class GoodsController {


    private final GoodsService goodsService;

    @GetMapping("/exhibit")
    public Object exhibit(PageDto dto) {
        List<GoodsEntity> entities = goodsService.exhibit(dto);
        return ResponseView.build(entities);
    }

    @PostMapping("/create")
    public ResponseView create(@RequestBody @Validated RequestDto dto) {
        GoodsEntity entity = goodsService.create(dto);
        return ResponseView.build(entity);
    }

}
