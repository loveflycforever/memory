package com.nafapap.memory.config;

import cn.org.atool.fluent.mybatis.spring.MapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Project: memory </p>
 * <p>Name: MybatisConfig </p>
 * <p>Description: ${描述} </p>
 * <p>Date: 2022/3/8 13:13 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@Configuration
public class MybatisConfig {

    @Bean
    public MapperFactory mapperFactory() {
        return new MapperFactory();
    }
}
