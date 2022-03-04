package com.nafapap.memory;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Project: memory </p>
 * <p>Name: GreetingController </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/3/1 16:33 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Api(tags = "欢迎接口")
@RestController
public class GreetingController {

    @ApiOperation("hello")
    @GetMapping("/hello")
    public String hello(
            @ApiParam(name = "name", value = "World")
            @RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
