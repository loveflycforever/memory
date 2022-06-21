package com.nafapap.memory.mgmt.economy.controller;

import com.nafapap.memory.mgmt.economy.service.ThingService;
import com.nafapap.memory.mgmt.economy.transobj.*;
import com.nafapap.memory.source.entity.ThingEntity;
import com.nafapap.memory.support.web.ResponseView;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: ThingController </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/23 13:27 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Api(tags = "ThingController")
@RestController
@RequiredArgsConstructor
@RequestMapping("/thing")
public class ThingController {

    private final ThingService thingService;

    @GetMapping("/exhibit")
    public Object exhibit(ThingPageDto dto) {
        List<ThingVO> entities = thingService.exhibit(dto);
        return ResponseView.build(entities);
    }

    @PostMapping("/create")
    public ResponseView create(@RequestBody @Validated ThingRequestDto dto) {
        ThingEntity entity = thingService.create(dto);
        return ResponseView.build(entity);
    }
}
