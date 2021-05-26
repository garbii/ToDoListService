package com.modanisa.openapi

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.servers.Server
import org.springdoc.core.GroupedOpenApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile


@Profile("!prod")
@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenAPI(@Value("\${spring.application.description}") appDesciption: String?,
                      @Value("\${spring.application.version}") appVersion: String?,
                      @Value("\${spring.application.name}") appName: String): OpenAPI {
        val openApi = OpenAPI()
              .info(Info()
                        .title(appName)
                        .version(appVersion)
                        .description(appDesciption)
                        .termsOfService("http://springdoc.org")
                        .license(License().name("Modanisa License"))
                        .contact(Contact().name("Garbi Özyıldız").email("garbiozyldz@gmail.com")))

        openApi.addServersItem(Server().url("/"))

        return openApi
    }

    @Bean
    fun managementApis(): GroupedOpenApi {
        return GroupedOpenApi.builder()
                .group("Management")
                .pathsToMatch("/management/**")
                .build()
    }

    @Bean
    fun publicApis(): GroupedOpenApi {
        return GroupedOpenApi.builder()
                .group("Public Endpoints")
                .packagesToScan("com.modanisa.controller")
                .build()
    }
}