package com.pepsiwyl.controller;

import com.pepsiwyl.pojo.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by pepsi-wyl
 * @date 2022-04-20 10:34
 */

@Api(tags = "用户服务相关接口描述")

@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(
            value = "查询所有用户接口",
            notes = "描叙:用来查询所有用户信息的接口")
    @GetMapping(name = "查询所有用户接口", path = "/getAll")
    public Map<String, Object> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("success", "查询所有数据成功");
        map.put("status", true);
        return map;
    }

//    @ApiOperation(
//            value = "保存用户信息接口",
//            notes = "描叙:用来保存用户信息的接口")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "username", value = "用户姓名", dataType = "String"),
//            @ApiImplicitParam(name = "password", value = "用户密码", dataType = "String")
//    })
//    @PostMapping(name = "保存用户信息接口", path = "/save")
//    public Map<String, Object> save(@RequestParam("username") String userName, @RequestParam("password") String password) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("username", userName);
//        map.put("password", password);
//        return map;
//    }

    @ApiOperation(
            value = "保存用户信息接口",
            notes = "描叙:用来保存用户信息的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户姓名", dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "password", value = "用户密码", dataType = "String", paramType = "path")
    })

    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })

    @PostMapping(name = "保存用户信息接口", path = "/save/{username}/{password}")
    public Map<String, Object> save(@PathVariable("username") String userName, @PathVariable("password") String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", userName);
        map.put("password", password);
        return map;
    }

//    @ApiOperation(
//            value = "保存用户信息接口",
//            notes = "描叙:用来保存用户信息的接口")
//    @PostMapping(name = "保存用户信息接口", path = "/save")
//    public Map<String, Object> save(@RequestBody User user) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("username", user.getUserName());
//        map.put("password", user.getPassword());
//        return map;
//    }

}
