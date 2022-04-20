# 简介
## 引言
相信无论是前端还是后端开发，都或多或少地被接口文档折磨过。
```java
前端经常抱怨后端给的接口文档和实际情况不一致。
后端又觉得编写及维护接口文档会耗费不少精力，经常来不及更新。
其实无论是前端调用后端，还是后端调用前端，都期望有一个好的接口文档。

但是这个接口文档对于程序员来说，就跟注释一样，经常还会抱怨别人写的代码没有写注释，然而自己写起代码来，最讨厌的也是写注释。
所以仅仅只听过强制了来规范大家是不够的，随着时间推移，版本迭代，接口文档往往很容易就跟不上代码了。
```
发现了痛点就要去找解决方案。解决方案用的人多了，就成了标准的规范，这就是 Swagger 的由来。
## 简介
```java
通过这套规范，你只需要按照它的规范去定义接口及接口相关信息。再通过 Swagger 衍生出来的一系列项目
和工具，就可以做到生成各种格式的接口文档，生成多做语言的客户端和服务端的代码，以及在线接口调试页面等等。
这样，如果按照新的开发方式，在开发新版本或者迭代版本的时候，只需要更新 Swagger 描述文件，就可以自动生
成接口文档和客户端代码，做到调用端代码、服务端代码以及接口文档的一致性。
```
```markdown
但即便如此，对于许多开发来说，编写这个 yml 或 json 格式的描述文件，本身也是有一定负担的工作，特别是
在后面持续迭代开发的时候，往往会忽略更新这个描述文件，直接更改代码。久而久之，这个描述文件也和实际项
目渐行渐远，基于该描述文件生成的接口文档也失去了参考意义。
```
```markdown
所以作为 Java 界服务端的大一统框架 Spring，迅速将Swagger 规范纳入自身的标准，建立了 
Spring-swagger 项目，后面改成了现在的 Springfox。通过在项目中引入 Springfox，可以
扫描相关的代码，生成该描述文件，进而生成与代码一致的接口文档和客户端代码。这种通过代码
生成接口文档的形式，在后面需求持续迭代的项目中，显得尤为重要和高效。
```
![20210710161346361.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1650367511728-fe4319e9-e785-4b38-9d31-a1be16695821.png#clientId=u099ce749-d97f-4&crop=0&crop=0&crop=1&crop=1&from=drop&id=u98b51f78&margin=%5Bobject%20Object%5D&name=20210710161346361.png&originHeight=541&originWidth=1276&originalType=binary&ratio=1&rotation=0&showTitle=false&size=192787&status=done&style=none&taskId=u89604883-b631-4cb5-8b11-c4823762d05&title=)
## 总结
Swagger 就是一个用来定义接口标准，接口规范，同时能根据你的代码自动生成接口说明文档的一个工具。
# 官方提供的工具
## ![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1650368128197-894eb752-5289-4b36-96aa-97c2d0533e38.png#clientId=u099ce749-d97f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=774&id=u1dcfe374&margin=%5Bobject%20Object%5D&name=image.png&originHeight=774&originWidth=1260&originalType=binary&ratio=1&rotation=0&showTitle=false&size=119179&status=done&style=none&taskId=u91b04351-9b4b-4799-902d-f5528a4e94e&title=&width=1260)Swagger Codegen
通过Codegen 可以将描述文件生成 html 格式和 cwiki 形式的接口文档，同时也能生成多种语言的服务端和客端代码。
支持通过 jar 包、docker、node 等方式在本地化执行生成。也可以在后面的 Swagger Editor 中在线生成。
## Swagger Editor
类似于 Markdown 编辑器的编辑 Swagger描述文件的编辑器，该编辑器支持实时预览描述文件的更新效果，也提供了在线编辑器和本地部署器俩种方式。
## Swagger UI
提供了一个可视化的 UI 页面展示描述文件。接口的调用方、测试、项目经理等都可以在该页面中对相关接口进行查阅和做一些简单的接口请求。该项目支持在线导入描述文件和本地部署 UI 项目。
## Swagger Inspector
和 Postman 差不多，是一个可以对接口进行测试的在线版的 postman。比如在 Swagger UI 里面做接口请求，会返回更多的信息，也会保存你请求的实际请求参数等数据。
## Swagger Hub
集成了上面所有项目的各个功能，你可以以项目和版本为单位，将你的描述文件上传到 Swagger Hub 中。在Swagger Hub 中可以完成上面项目的所有工作，需要注册账号，分免费版和收费版。
## Springfox Swagger
Spring 基于 Swagger 规范，可以将基于 SpringMVC 和 Spring Boot 项目的项目代码，自动生成 JSON 格式的描述文件。本身不是属于 Swagger 官网提供的，在这里列出来做个说明，方便后面作一个使用的展开。
# 整合SpringBoot
## SpringBoot-Version
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1650418770229-8341b575-f934-42f8-9c0c-8fc400435b0e.png#clientId=ufa968b18-faf0-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=137&id=ufe287538&margin=%5Bobject%20Object%5D&name=image.png&originHeight=137&originWidth=500&originalType=binary&ratio=1&rotation=0&showTitle=false&size=94965&status=done&style=none&taskId=u2d995983-063f-4412-9ff5-7c4b1417337&title=&width=500)
注意:
        SpringBoot版本不能过高   (2.5.6)
## Dependency
```xml
<!--Spring-Boot Web启动器-->
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
```xml
<!--Swagger3.0 启动器-->
<dependency>
     <groupId>io.springfox</groupId>
     <artifactId>springfox-boot-starter</artifactId>
     <version>3.0.0</version>
</dependency>
```
```xml
<!--java.lang的增强版-->
<dependency>
      <groupId>org.apache.commons</groupId>
      <artifactId>commons-lang3</artifactId>
      <version>3.9</version>
</dependency>
<!--Lombok简化开发-->
<dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <optional>true</optional>
</dependency>
<!--yaml文件配置提示-->
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-configuration-processor</artifactId>
      <optional>true</optional>
</dependency>
```
## SwaggerProperties
```java
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
```
## SwaggerConfig
```java
import com.pepsiwyl.config.properties.SwaggerProperties;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.boot.SpringBootVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author by pepsi-wyl
 * @date 2022-04-19 20:38
 */

@EnableOpenApi // 新增该注解
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Resource(name = "swaggerProperties")
    SwaggerProperties swaggerProperties;

    //可以创建多个Docket对象，添加进@Bean中 并使用 .groupName("张*") 添加多个分组，前提是名称不要重复
    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.OAS_30)
                .pathMapping("/")

                .groupName("pepsi-wyl")

                // 定义是否开启swagger，false为关闭，可以通过变量控制
                .enable(swaggerProperties.getEnable())

                // 将api的元信息设置为包含在json ResourceListing响应中。
                .apiInfo(apiInfo())

                // 接口调试地址
                .host(swaggerProperties.getTryHost())

                // 选择哪些接口作为swagger的doc发布
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pepsiwyl.controller"))
                .paths(PathSelectors.any())
                .build()

                // 支持的通讯协议集合
                .protocols(newHashSet("https", "http"))

                // 授权信息设置，必要的header token等认证信息
                .securitySchemes(securitySchemes())

                // 授权信息全局应用
                .securityContexts(securityContexts());

        //any() 扫描全部
        //none() 都不扫描
        //RequestHandlerSelectors                    配置要扫描接口的方式
        //RequestHandlerSelectors.basePackage("")    指定要扫描的包
        //.withClassAnnotation(RestController.class) 扫描类上的注解
        //.withMethodAnnotation(GetMapping.class)    扫描方法上的注解

    }

    /**
     * API 页面上半部分展示信息
     * 可以new ApiInfo对象，到ApiInfo里面去看源码
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题
                .title(swaggerProperties.getApplicationName() + " Api Doc")
                // 详细信息
                .description(swaggerProperties.getApplicationDescription())
                // 版本信息
                .version("Application Version: " + swaggerProperties.getApplicationVersion() + ", Spring Boot Version: " + SpringBootVersion.getVersion())
                // 开发文档联系人信息
                .contact(new Contact(swaggerProperties.getUserName(), swaggerProperties.getUserUrl(), swaggerProperties.getUserEmail()))
                .build();
    }

    /**
     * 支持的通讯协议集合
     */
    @SafeVarargs
    private <T> Set<T> newHashSet(T... ts) {
        if (ts.length > 0) {
            return new LinkedHashSet<>(Arrays.asList(ts));
        }
        return null;
    }

    /**
     * 授权信息设置
     */
    private List<SecurityScheme> securitySchemes() {
        ApiKey apiKey = new ApiKey("BASE_TOKEN", "token", In.HEADER.toValue());
        return Collections.singletonList(apiKey);
    }

    /**
     * 授权信息全局应用
     */
    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(Collections.singletonList(new SecurityReference("BASE_TOKEN", new AuthorizationScope[]{new AuthorizationScope("global", "")})))
                        .build()
        );
    }

    /**
     * 通用拦截器排除swagger设置，所有拦截器都会自动加swagger相关的资源排除信息
     */
    @SuppressWarnings("unchecked")
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        try {
            Field registrationsField = FieldUtils.getField(InterceptorRegistry.class, "registrations", true);
            List<InterceptorRegistration> registrations = (List<InterceptorRegistration>) ReflectionUtils.getField(registrationsField, registry);
            if (registrations != null) {
                for (InterceptorRegistration interceptorRegistration : registrations) {
                    interceptorRegistration
                            .excludePathPatterns("/swagger**/**")
                            .excludePathPatterns("/webjars/**")
                            .excludePathPatterns("/v3/**")
                            .excludePathPatterns("/doc.html");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
```
## YAML
```yaml
spring:
  application:
    name: Springfox-Swagger
server:
  port: 8080

# ===== swagger ===== #
swagger:
  enable: true
  application-name: ${spring.application.name}
  application-version: 1.0
  application-description: springfox swagger 3.0 Demo
  user-name: pepsi-wyl
  user-url: http://blog.pepsi-wyl.xyz
  user-email: 2322535585@qq.com
  try-host: http://localhost:${server.port}
```
## TestController
```java
@RestController
public class HelloController {
    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello";
    }
}
```
## 访问API地址
```yaml
http://127.0.0.1:8080/swagger-ui/index.html
```
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1650419841679-89a48dfc-0990-4869-8a24-6c6768780c60.png#clientId=ufa968b18-faf0-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=324&id=u7c40c53c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=360&originWidth=412&originalType=binary&ratio=1&rotation=0&showTitle=false&size=184643&status=done&style=none&taskId=u64f2a38a-4347-4c00-8387-1615eb6844e&title=&width=371)
# 常用注解
## Pojo
### @ApiModel
```java
// 提供有关swagger模型的其它信息
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ApiModel {
    String value() default "";        		// 为模型提供备用名称 
    String description() default "";  		// 提供详细的类描述
    Class<?> parent() default Void.class;   // 为模型提供父类以允许描述继承关系
    String discriminator() default "";      // 支持模型继承和多态，使用鉴别器的字段的名称，可以断言需要使用哪个子类型
    Class<?>[] subTypes() default {};       // 从此模型继承的子类型数组
    String reference() default "";          // 指定对应类型定义的引用，覆盖指定的任何其他元数据
}
```
### @ApiModelProperty
```java
// 用于字段，表示对 model 属性的说明
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiModelProperty {
    String value() default "";              // 属性简要说明
    String name() default "";               // 运行覆盖属性的名称。重写属性名称
    String allowableValues() default "";    // 限制参数可接收的值，三种方法，固定取值，固定范围
    String access() default "";             // 过滤属性，参阅:io.swagger.core.filter.SwaggerSpecFilter
    String notes() default "";              // 目前尚未使用
    String dataType() default "";           // 参数的数据类型，可以是类名或原始数据类型，此值将覆盖从类属性读取的数据类型
    boolean required() default false;       // 是否为必传参数,false:非必传参数; true:必传参数
    int position() default 0;               // 允许在模型中显示排序属性
    boolean hidden() default false;         // 隐藏模型属性，false:不隐藏; true:隐藏
    String example() default "";            // 属性的示例值
    @Deprecated
    boolean readOnly() default false;       // 指定模型属性为只读，false:非只读; true:只读
    ApiModelProperty.AccessMode accessMode() default ApiModelProperty.AccessMode.AUTO;
    String reference() default "";          // 指定对应类型定义的引用，覆盖指定的任何其他元数据
    boolean allowEmptyValue() default false;// 允许传空值，false:不允许传空值; true:允许传空值
}
```
### 实例
```java
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
```
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1650432886987-a2156fbc-494d-422a-a4a2-46877462b5fd.png#clientId=u0be27c6c-b6e2-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=389&id=u0e3e8e97&margin=%5Bobject%20Object%5D&name=image.png&originHeight=389&originWidth=914&originalType=binary&ratio=1&rotation=0&showTitle=false&size=16906&status=done&style=none&taskId=uece4d323-0048-4dea-9660-420fd01bc40&title=&width=914)
## Controller
### @Api
```java
作用：用来指定接口的描述文字
修饰范围：用在类上
```
```java
@Api(tags = {"用户服务相关接口描叙"})   // tags：接口说明，可以在页面中显示。可以配置多个，当配置多个的时候，在页面中会显示多个接口的信息
@RestController
public class UserController {

}
```
### @ApiOperation
```java
作用：用来对接口中具体方法做描叙
修饰范围：用在方法上
```
```java
@ApiOperation(value = "查询所有用户接口", notes = "<span style='color:red;'>描叙:</span>&nbsp;&nbsp;用来查询所有用户信息的接口")
@GetMapping("/findAll")
public Map<String, Object> findAll() {
    Map<String, Object> map = new HashMap<>();
    map.put("success", "查询所有数据成功");
    map.put("status", true);
    return map;
}
```
### @ApiImplicitParams
```java
作用：用来接口中参数进行说明
修饰范围：用在方法上
```
```java
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiImplicitParam {
    String name() default "";               // 参数名，对应方法中单独的参数名称
    String value() default "";              // 参数中文说明
    String defaultValue() default "";       // 默认值
    boolean required() default false;       // 是否必填
    String dataType() default "";           // 参数数据类型
    String paramType() default "";          // 参数类型，取值为 path、query、body、header、form
}
```
#### @RequestParam (普通)
```java
@ApiOperation(
        value = "保存用户信息接口",
        notes = "描叙:用来保存用户信息的接口")
@ApiImplicitParams({
        @ApiImplicitParam(name = "username", value = "用户姓名", dataType = "String"),
        @ApiImplicitParam(name = "password", value = "用户密码", dataType = "String")
})
@PostMapping(name = "保存用户信息接口", path = "/save")
public Map<String, Object> save(@RequestParam("username") String userName, @RequestParam("password") String password) {
    Map<String, Object> map = new HashMap<>();
    map.put("username", userName);
    map.put("password", password);
    return map;
}
```
#### @PathVariable (RESTFul)
```java
@ApiOperation(
        value = "保存用户信息接口",
        notes = "描叙:用来保存用户信息的接口")
@ApiImplicitParams({
    
        @ApiImplicitParam(name = "username", value = "用户姓名", dataType = "String", paramType = "path"),
        @ApiImplicitParam(name = "password", value = "用户密码", dataType = "String", paramType = "path")
})
@PostMapping(name = "保存用户信息接口", path = "/save/{username}/{password}")
public Map<String, Object> save(@PathVariable("username") String userName, @PathVariable("password") String password) {
    Map<String, Object> map = new HashMap<>();
    map.put("username", userName);
    map.put("password", password);
    return map;
}
```
#### @RequestBody (JSON)
```java
@ApiOperation(
        value = "保存用户信息接口",
        notes = "描叙:用来保存用户信息的接口")
@PostMapping(name = "保存用户信息接口", path = "/save")
public Map<String, Object> save(@RequestBody User user) {   // user为对象 model模型
    Map<String, Object> map = new HashMap<>();
    map.put("username", user.getUserName());
    map.put("password", user.getPassword());
    return map;
}
```
### @ApiResponses
@ApiResponses 组装了多个 @ApiResponse  
@ApiResponse 用于方法上，说明接口响应的一些信息
```java
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
```
# 导出PDF
## 获取JSON数据
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1650434691625-f17d3fc1-4210-4672-aabb-5ee1db44eda2.png#clientId=u0be27c6c-b6e2-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=385&id=ub594fb2b&margin=%5Bobject%20Object%5D&name=image.png&originHeight=350&originWidth=466&originalType=binary&ratio=1&rotation=0&showTitle=false&size=40985&status=done&style=none&taskId=u5b7bbd98-c136-4a13-8e4d-1fbb5808c1f&title=&width=512)
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1650434705980-83ed396a-9b5e-4dc8-bf41-e87e575906a0.png#clientId=u0be27c6c-b6e2-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=495&id=u63e0200a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=495&originWidth=514&originalType=binary&ratio=1&rotation=0&showTitle=false&size=50641&status=done&style=none&taskId=u3ad00e8a-b3f4-48c2-967c-6ab13a5ca56&title=&width=514)
## 访问[小幺鸡](http://xiaoyaoji.cn)
[

](http://xiaoyaoji.cn)
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1650435071264-b74d39a7-f31e-4822-a504-05c919500501.png#clientId=u0be27c6c-b6e2-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=538&id=u1c4d96a8&margin=%5Bobject%20Object%5D&name=image.png&originHeight=538&originWidth=1210&originalType=binary&ratio=1&rotation=0&showTitle=false&size=96439&status=done&style=none&taskId=u0fce5c95-0772-42d5-85dc-552dabe074e&title=&width=1210)

## 生成文档
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1650434784379-bdcdc9f2-d76a-4879-a55e-05de416b8a51.png#clientId=u0be27c6c-b6e2-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=592&id=U6XnJ&margin=%5Bobject%20Object%5D&name=image.png&originHeight=592&originWidth=1004&originalType=binary&ratio=1&rotation=0&showTitle=false&size=35406&status=done&style=none&taskId=uf20eb650-ccab-4694-928b-cb5128797b5&title=&width=1004)
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1650434834585-2880cd44-58e4-4081-94e2-31683affd438.png#clientId=u0be27c6c-b6e2-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=526&id=ua1ed9fbc&margin=%5Bobject%20Object%5D&name=image.png&originHeight=526&originWidth=963&originalType=binary&ratio=1&rotation=0&showTitle=false&size=31712&status=done&style=none&taskId=u404760a8-b5cc-446c-b65b-261c766be42&title=&width=963)
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1650434987199-0a6d6b05-49b0-4964-81d5-7b6d6156a041.png#clientId=u0be27c6c-b6e2-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=476&id=ua67cb3b1&margin=%5Bobject%20Object%5D&name=image.png&originHeight=476&originWidth=945&originalType=binary&ratio=1&rotation=0&showTitle=false&size=21467&status=done&style=none&taskId=u17147503-46a4-4b0f-b54f-2445c6129ea&title=&width=945)

![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1650434861754-22e0d63e-9e40-4740-b2c7-317b4abe2df8.png#clientId=u0be27c6c-b6e2-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=708&id=u595a8e44&margin=%5Bobject%20Object%5D&name=image.png&originHeight=708&originWidth=1253&originalType=binary&ratio=1&rotation=0&showTitle=false&size=59762&status=done&style=none&taskId=u31478856-d3ca-4901-b568-b83c9548a00&title=&width=1253)
## 导出文档
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1650434885187-f5fa4543-20fe-4037-9678-ebd090090d87.png#clientId=u0be27c6c-b6e2-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=541&id=u20d78c44&margin=%5Bobject%20Object%5D&name=image.png&originHeight=541&originWidth=1014&originalType=binary&ratio=1&rotation=0&showTitle=false&size=42342&status=done&style=none&taskId=u24e0ca87-c35f-485d-8bc1-d72b8c70017&title=&width=1014)![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1650434895258-48b372b8-c4e4-470f-aad9-c9ffdc4d951b.png#clientId=u0be27c6c-b6e2-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=378&id=u5f2191d3&margin=%5Bobject%20Object%5D&name=image.png&originHeight=378&originWidth=953&originalType=binary&ratio=1&rotation=0&showTitle=false&size=23373&status=done&style=none&taskId=u24952670-78e9-4b0d-9f35-6cb3586a5bf&title=&width=953)
## ![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1650435271902-633e3c1c-e64c-413c-9e27-5de68b228788.png#clientId=ubeb6adad-09f3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=872&id=u27e7d25b&margin=%5Bobject%20Object%5D&name=image.png&originHeight=872&originWidth=1235&originalType=binary&ratio=1&rotation=0&showTitle=false&size=105017&status=done&style=none&taskId=u19151a4d-d78d-41ac-bbba-d9c3b4c7b2f&title=&width=1235)



