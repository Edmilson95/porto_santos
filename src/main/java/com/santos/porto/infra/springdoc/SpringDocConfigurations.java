package com.santos.porto.infra.springdoc;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("API Porto de Santos")
                        .description("API Rest da aplicação Porto de Santos, contendo as funcionalidades de criar, ler, atualizar, deletar, além de criação de agendamentos e cancelamentos de visitas aos conteiners.")
                        .contact(new Contact()
                                .name("Edmilson Ferreira")
                                .email("edmilson.svic@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://porto.santos/api/licenca")));
    }

}
