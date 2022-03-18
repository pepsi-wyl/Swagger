package com.pepsiwyl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author by pepsi-wyl
 * @date 2022-03-08 16:56
 */


@Configuration
@EnableSwagger2    // 开启Swagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("pepsi-wyl")   // 组名称
                .enable(true)   // 是否开启 (true 开启  false隐藏。生产环境建议隐藏)
                .select()
                //扫描的路径包,设置basePackage会将包下的所有被@Api标记类的所有方法作为api
                .apis(RequestHandlerSelectors.basePackage("com.pepsiwyl.controller"))
                //指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any()).
                build();
    }

    // 配置Swagger信息 项目信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档标题(API名称)
                .title("API接口文档")
                //文档描述
                .description("文档说明")
                //版本号
                .version("1.0.0")
                .build();
    }

}