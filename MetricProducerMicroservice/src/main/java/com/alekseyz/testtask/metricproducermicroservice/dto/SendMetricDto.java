package com.alekseyz.testtask.metricproducermicroservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;


@Schema(description = "Набор параметров метрики для маппинга в него Jsona с Producer API")

@Value
@Builder
public class SendMetricDto {

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
