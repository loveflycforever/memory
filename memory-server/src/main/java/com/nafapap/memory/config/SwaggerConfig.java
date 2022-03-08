package com.nafapap.memory.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * <p>Project: memory </p>
 * <p>Name: SwaggerConfig </p>
 * <p>Description:
 * http://localhost:8085/memory/swagger-ui/index.html
 * http://localhost:8085/memory/docs.html
 * </p>
 * <p>Date: 2022/3/1 16:33 </p>
 * <p>Company: Cupshe Company Limited </p>
 *
 * @author yuchaofan
 * @version v1.0
 */
@EnableOpenApi
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 生成接口信息，包括标题、联系人，联系方式等
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Memory接口文档")
                .description("如有疑问，请联系开发工程师")
                .contact(new Contact("papafan", "https://www.papafan.com/", "papafan2020@outlook.com"))
                .version("1.0")
                .build();
    }
}