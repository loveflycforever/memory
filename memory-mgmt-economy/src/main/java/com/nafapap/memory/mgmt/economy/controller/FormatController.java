package com.nafapap.memory.mgmt.economy.controller;

import com.nafapap.memory.mgmt.economy.service.FormatService;
import com.nafapap.memory.mgmt.economy.transobj.FormatRequestDto;
import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.source.entity.SubjectEntity;
import com.nafapap.memory.support.web.ResponseView;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: FormatController </p>
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
@RequestMapping("/format")
public class FormatController {

    private final FormatService formatService;

    @GetMapping("/exhibit")
    public Object exhibit(PageDto dto) {
        List<SubjectEntity> entities = formatService.exhibit(dto);
        return ResponseView.build(entities);
    }

    @PostMapping("/create")
    public ResponseView create(@RequestBody @Validated FormatRequestDto dto) {
        SubjectEntity entity = formatService.create(dto);
        return ResponseView.build(entity);
    }


}
