package com.TourPackageManagmentAssignment.Tour_Package_Managment_Assignment.configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myApiConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tour Package Task APIs")
                        .description("By Nikhil Khure"))
                .servers(
                        Arrays.asList(new Server().url("http://localhost:8080").description("local"))
                );

    }

}
