package com.wechat.config;

import com.google.common.base.Predicate;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;



//  localhost:1230/swagger-ui.html
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket userApi() {
        Predicate<RequestHandler> swaggerSelector = RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class);
        return new Docket(DocumentationType.SWAGGER_2)
//               .securitySchemes(newArrayList(new BasicAuth("test"))) //账号密码登录
//               .enable(false)   //禁止使用
                .apiInfo(apiInfo())
                .select()
//               .apis(RequestHandlerSelectors.basePackage("com.boot"))
                .apis(swaggerSelector)
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("boot RESTFul APIs")
                .description("构建restful api,learn more:springfox.io")
                .license("Licens")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .contact(new Contact("boot","官网地址url","email地址"))
                .version("0.0.1")
                .build();
    }

    ApiKey apiKey() {
        return new ApiKey("sessionId", "sessionId", "header");
    }
}
