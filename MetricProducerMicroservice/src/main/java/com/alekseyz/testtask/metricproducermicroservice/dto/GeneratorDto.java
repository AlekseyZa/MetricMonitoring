package com.alekseyz.testtask.metricproducermicroservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(description = "Набор параметров метрики для использования в автогенераторе POST запросов на Producer API")
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class GeneratorDto {

    @Schema(description = "Источник метрики")
    String source;
    @Schema(description = "Тип метрики")
    String metricType;
    @Schema(description = "Название метрики")
    String metricName;
    @Schema(description = "Значение метрики")
    String metricValue;
    @Schema(description = "время сбора метрики")
    LocalDateTime timestamp;
}
