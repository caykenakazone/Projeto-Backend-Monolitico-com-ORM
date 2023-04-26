package com.iftm.subscription.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Documentação da API sobre o Sistema subscripition")
                        .version("Versão 1 (v1)")
                        .description("Esta é uma documentação da API Subscripition")
                        .termsOfService("http://myTerms.com")
                        .license(new License().name("Apache 2.0").url("http://myLicence.com"))
                );
    }
}
