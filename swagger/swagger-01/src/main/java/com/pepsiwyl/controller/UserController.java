package com.pepsiwyl.controller;

import com.pepsiwyl.pojo.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author by pepsi-wyl
 * @date 2022-03-08 19:26
 */

@Api(value = "User", tags = {"User"}, description = "用户相关")
@RestController(value = "userController")
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {

    @ApiOperation(value = "根据ID查询用户")
    @ApiImplicitParams(@ApiImplicitParam(value = "ID", name = "id", dataType = "int", paramType = "path", required = true, defaultValue = "1"))
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return new User(id, "pepsi-wyl", "999999");
    }

}
