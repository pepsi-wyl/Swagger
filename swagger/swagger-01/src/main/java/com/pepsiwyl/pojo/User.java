package com.pepsiwyl.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author by pepsi-wyl
 * @date 2022-03-08 19:21
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@ApiModel(description = "用户Model")

@Component("user")
public class User {
    @ApiModelProperty(value = "用户ID", name = "id")
    private Integer id;

    @ApiModelProperty(value = "用户名", name = "username", required = true, example = "pepsi-wyl")
    private String userName;

    @ApiModelProperty(value = "密码", name = "password", required = true, example = "999999")
    private String password;
}
