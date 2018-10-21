package com.api.hr;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Contact CONTACT = new Contact("Jose", "https://github.com/thewizardofjoz/",
        "josesmithesh@gmail.com");
    private static final ApiInfo API_INFO = new ApiInfo("HR Api Documentation", "HR Api Description", "1.0", "none",
        CONTACT, "MIT License", "https://opensource.org/licenses/MIT");
    private static final Set<String> SUPPORTED_CONTENT_TYPES = Stream.of("application/json", "application/xml")
        .collect(Collectors.toSet());


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(API_INFO)
            .produces(SUPPORTED_CONTENT_TYPES)
            .consumes(SUPPORTED_CONTENT_TYPES);
    }

}
