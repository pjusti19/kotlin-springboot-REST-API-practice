package br.com.pedro.kotlin_springboot_REST_API_practice.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenApi (): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Kotlin Spring Boot API")
                    .version("1.0.0")
                    .description("Kotlin Spring Boot API")
                    .termsOfService("https://swagger.io/")
            )
    }
}