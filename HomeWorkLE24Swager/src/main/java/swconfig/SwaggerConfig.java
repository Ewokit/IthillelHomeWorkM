package swconfig;

import org.apache.coyote.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger1.annotations.EnableSwagger;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.any()).paths(regex("/api/.")).build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Rest API").description("Hillel\"REST API\"")
                .version("27.03.23").build();
    }
}
