package com.alekseyz.testtask.metricconsumermicroservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

@Schema(description = "Набор параметров метрики для запроса списка всех метрик")
@Builder
@Value
public class ReadMetricDto {
    @Schema(description = "Id")
    Long id;
    @Schema(description = "Источник метрики")
    String source;
    @Schema(description = "Тип метрики")
    String metricType;
    @Schema(description = "Название метрики")
    String metricName;
    @Schema(description = "Значение метрики")
    String metricValue;
    @Schema(description = "время сбора метрики")
    String timestamp;
}
