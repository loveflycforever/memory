package com.nafapap.memory.mgmt.economy.controller.base;

import com.nafapap.memory.mgmt.economy.transobj.PageDto;
import com.nafapap.memory.support.web.ResponseView;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>Project: memory </p>
 * <p>Name: AbstractController </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/9/27 15:02 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
public abstract class AbstractController<D, V> implements RequiredServiceable<D, V> {

    @ApiOperation("展示")
    @GetMapping("/exhibit")
    public Object exhibit(PageDto dto) {
        List<V> actualVos = actualService().exhibit(dto);
        return ResponseView.build(actualVos);
    }

    @ApiOperation("创建")
    @PostMapping("/create")
    public ResponseView create(@RequestBody @Validated D dto) {
        V actualViewObject = actualService().create(dto);
        return ResponseView.build(actualViewObject);
    }

    @ApiOperation("预备")
    @PostMapping("/prepare")
    public ResponseView prepare(@RequestBody @Validated D dto) {
        V actualViewObject = actualService().prepare(dto);
        return ResponseView.build(actualViewObject);
    }

    @ApiOperation("确定")
    @PostMapping("/confirm")
    public ResponseView confirm(@RequestBody @Validated D dto) {
        V actualViewObject = actualService().confirm(dto);
        return ResponseView.build(actualViewObject);
    }
}
