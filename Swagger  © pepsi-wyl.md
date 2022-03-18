# 简介
## 后端时代
    前端只需要 管理静态页面
## 前后端分离
### 后端

- 后端控制层 服务层 数据库访问层   【后端团队】
### 前端

- 前端控制层 视图层    【前端团队】
- 伪造后端数据 json 
### 交互

- API进行交互
- 前后端相互独立，松耦合
- 前后段可以部署在不同的服务器上
#### 问题 
前后端集成联调，前端人员和后端人员无法做到"及时协商"
       在平时开发中，一个好的API文档可以减少大量的沟通成本，还可以帮助新加入项目的同事快速上手业务。大家都知道平时开发时，接口变化总是很多，有了变化就要去维护，也是一件比较头大的事情。尤其是现在前后端分离情况，更容易造成文档和代码不一致。这时，我们可以通过Swagger2来使接口规范，方便维护。
## [Swagger](https://swagger.io/)

- 号称世界上最流行的Api框架
- RestFul Api文档在线自动生产工具 ======> Api文档与API定义同步更新
- 可以直接运行，可以在线测试Api接口
- 支持多种语言 (java php)
# 入门
## 新建Boot工程
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1646729270488-df9c9b04-a28f-4167-bc28-26109ce9dc85.png#clientId=ud4465767-7445-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=675&id=uc46dbb95&margin=%5Bobject%20Object%5D&name=image.png&originHeight=675&originWidth=727&originalType=binary&ratio=1&rotation=0&showTitle=false&size=56306&status=done&style=none&taskId=uf5e4a747-95b4-4666-b45b-6ac14b9db3d&title=&width=727)
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1646729308197-7d4b3729-5913-470e-a1d5-6323c456f8a0.png#clientId=ud4465767-7445-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=675&id=u3053ce90&margin=%5Bobject%20Object%5D&name=image.png&originHeight=675&originWidth=727&originalType=binary&ratio=1&rotation=0&showTitle=false&size=59876&status=done&style=none&taskId=ud7760478-842e-4552-9beb-32e20748b04&title=&width=727)
## 导入依赖
```xml
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-swagger2</artifactId>
  <version>2.9.2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
```
## 集成Swagger
```java
@Configuration
@EnableSwagger2
public class SwaggerConfig {

}
```
## 编写Hello工程
```java
@RestController
public class HelloController {
    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello";
    }
}
```
## 访问 [http://127.0.0.1:8080/swagger-ui.html#/](http://127.0.0.1:8080/swagger-ui.html#/)
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1646730824143-63ab49b5-e808-496f-8e36-f029a8a09ee1.png#clientId=ud4465767-7445-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=778&id=uf00ab9d9&margin=%5Bobject%20Object%5D&name=image.png&originHeight=778&originWidth=1295&originalType=binary&ratio=1&rotation=0&showTitle=false&size=60891&status=done&style=none&taskId=u1ab221fa-f267-4cd9-ae8a-820ecf85f7d&title=&width=1295)
注意:
        SpringBoot版本不能过高   (2.5.6)
# 高级
## 配置Swagger
```java
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
```
## 常用注解
### Api
@Api 用在类上，说明该类的作用。可以标记一个 Controller 类作为 Swagger 文档资源
```java
@Api(tags={"用户接口"})  // tags：接口说明，可以在页面中显示。可以配置多个，当配置多个的时候，在页面中会显示多个接口的信息
@RestController
public class UserController {

}
```
### ApiModel
@ApiModel 用在类上，表示对类进行说明，用于实体类中的参数接收说明
```java
@ApiModel(value = "com.biancheng.auth.param.AddUserParam", description = "新增用户参数")
public class AddUserParam {
}
```
### ApiModelProperty
@ApiModelProperty() 用于字段，表示对 model 属性的说明
```java
@Data
@ApiModel(value = "com.biancheng.auth.param.AddUserParam", description = "新增用户参数")
public class AddUserParam {
    @ApiModelProperty(value = "ID")
    private String id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "年龄")
    private int age;
}
```
### ApiParam
@ApiParam 用于 Controller 中方法的参数说明
```java
@PostMapping("/user")
// value：参数说明  required：是否必填
public UserDto addUser(@ApiParam(value = "新增用户参数", required = true) @RequestBody AddUserParam param) {
    System.err.println(param.getName());
    return new UserDto();
}
```
### ApiOperation
@ApiOperation 用在 Controller 里的方法上，说明方法的作用，每一个接口的定义
```java
// value：接口名称 notes：详细说明
@ApiOperation(value="新增用户", notes="详细描述")
public UserDto addUser(@ApiParam(value = "新增用户参数", required = true) @RequestBody AddUserParam param) {

}
```
### ApiResponse 和 ApiResponses
@ApiResponse 用于方法上，说明接口响应的一些信息；@ApiResponses 组装了多个 @ApiResponse
```java
@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = UserDto.class) })
@PostMapping("/user")
public UserDto addUser(@ApiParam(value = "新增用户参数", required = true) @RequestBody AddUserParam param) {
}
```
### ApiImplicitParam 和 ApiImplicitParams
用于方法上，为单独的请求参数进行说明
```java
@ApiImplicitParams({
    // 参数名，对应方法中单独的参数名称
    // 参数中文说明
    // 是否必填
    // 参数类型，取值为 path、query、body、header、form
    // 参数数据类型
    // 默认值
        @ApiImplicitParam(name = "id", value = "用户ID", dataType = "string", paramType = "query", required = true, defaultValue = "1") })
@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = UserDto.class) })
@GetMapping("/user")
public UserDto getUser(@RequestParam("id") String id) {
    return new UserDto();
}
```
## 实践
```java
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
```
```java
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
```
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1646741161775-59f82b3d-f7ca-4ddf-8ffe-3995ae91a6f0.png#clientId=ud4465767-7445-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=646&id=u08edf554&margin=%5Bobject%20Object%5D&name=image.png&originHeight=646&originWidth=987&originalType=binary&ratio=1&rotation=0&showTitle=false&size=38319&status=done&style=none&taskId=u287aa8a2-d9a1-43c7-9b64-4d1a33257e2&title=&width=987)
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1646741184160-fa003246-b4ae-4602-bae7-aabbbfc2d032.png#clientId=ud4465767-7445-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=954&id=u12aca8b5&margin=%5Bobject%20Object%5D&name=image.png&originHeight=954&originWidth=930&originalType=binary&ratio=1&rotation=0&showTitle=false&size=52322&status=done&style=none&taskId=u77804772-acb7-45cd-b70a-ac4e40f7de8&title=&width=930)
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1646741169284-9b3cf700-5953-4f00-8bf8-42247fb1e472.png#clientId=ud4465767-7445-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=353&id=uf1b68d0c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=353&originWidth=942&originalType=binary&ratio=1&rotation=0&showTitle=false&size=19281&status=done&style=none&taskId=u4de4500b-1d6c-4a54-9213-7094a3e7341&title=&width=942)



