package com.siit.hospital_manager.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This bean is used to config security access for SpringDoc with bearer token.
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "Hospital manager API", version = "1.0"))
public class SpringDocSecurityConfig {
    private static final String SCHEME_NAME = "spring_doc_security_config";
    private static final String SCHEME = "basic";

    @Bean
    OpenAPI customOpenApi() {
        return new OpenAPI().components(
                        new Components().addSecuritySchemes(SCHEME_NAME,
                                new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                        .scheme(SCHEME)))
                .addSecurityItem(new SecurityRequirement().addList(SCHEME_NAME));
    }
}
