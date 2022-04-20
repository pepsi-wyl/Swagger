package com.pepsiwyl.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author by pepsi-wyl
 * @date 2022-04-20 10:48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@ApiModel(value = "用户Model", description = "用户实体类")

public class User {

    @ApiModelProperty(value = "用户ID", name = "id", dataType = "int", example = "1001")
    private int id;

    @ApiModelProperty(value = "用户名", name = "username", dataType = "String", required = true, example = "pepsi-wyl")
    private String userName;

    @ApiModelProperty(value = "密码", name = "password", dataType = "String", required = true, example = "999999")
    private String password;

    @ApiModelProperty(value = "角色权限", name = "role", dataType = "String", example = "admin")
    private String role;

}