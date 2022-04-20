package com.pepsiwyl.config.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author by pepsi-wyl
 * @date 2022-04-19 20:27
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

@Component("swaggerProperties")
@ConfigurationProperties("swagger")
public class SwaggerProperties {

    /**
     * 是否开启swagger，生产环境一般关闭，所以这里定义一个变量
     */
    private Boolean enable;

    /**
     * 项目信息
     */
    // 应用名
    private String applicationName;
    // 项目版本信息
    private String applicationVersion;
    // 项目描述信息
    private String applicationDescription;
    // 接口调试地址
    private String tryHost;

    /**
     * 开发人员信息
     */
    // 联系人
    private String userName;
    // url网站地址
    private String userUrl;
    // 邮箱
    private String userEmail;

}
