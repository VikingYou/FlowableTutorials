package com.example.config;

import io.swagger.v3.oas.annotations.OpenAPI31;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger配置类
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("MyService")
                .pathsToMatch("/")
                .build();
    }

    @Bean
    public OpenAPI flowableOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Flowable流程")
                        .description("描述")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Flowable WiKi")
                        .url("http://springshop.wiki.github.org/docs"));
    }

//    @Bean
//    public Docket docket() {
//        return new Docket(DocumentationType.OAS_30)
//                .apiInfo(apiInfo())
//                .select()
//                //apis: 添加swagger接口提取范围
//                .apis(RequestHandlerSelectors.basePackage("com.example"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("微服务平台底层Flowable流程")
//                .description("flowableDemo流程")
//                .contact(new Contact("VikingYou", "https://github.com/bafeimao", "VikingYou@Gmail.com"))
//                .version("1.0")
//                .build();
//    }

}
