package com.nafapap.memory.mgmt.economy.controller;

import com.nafapap.memory.mgmt.economy.service.ProcureService;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.mgmt.economy.transobj.ProcureRequestDto;
import com.nafapap.memory.mgmt.economy.transobj.RequestDto;
import com.nafapap.memory.source.entity.ProcureEntity;
import com.nafapap.memory.support.web.ResponseView;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: ProcureController</p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/2/23 13:27 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Api(tags = "ProcureController")
@RestController
@RequiredArgsConstructor
@RequestMapping("/procure")
public class ProcureController {

    private final ProcureService procureService;

    @GetMapping("/exhibit")
    public Object exhibit(PageDto dto) {
        List<ProcureEntity> entities = procureService.exhibit(dto);
        return ResponseView.build(entities);
    }

    @PostMapping("/create")
    public ResponseView create(@RequestBody @Validated ProcureRequestDto dto) {
        ProcureEntity entity = procureService.create(dto);
        return ResponseView.build(entity);
    }

}
