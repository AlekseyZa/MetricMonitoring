package com.alekseyz.testtask.metricproducermicroservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Metric monitoring",
                description = "Приложение для сбора и сохранения метрик"
                , version = "1.0.0",
                contact = @Contact(
                        name = "Алексей Заборников"
                )
        )
)
public class OpenApiConfig {

}
