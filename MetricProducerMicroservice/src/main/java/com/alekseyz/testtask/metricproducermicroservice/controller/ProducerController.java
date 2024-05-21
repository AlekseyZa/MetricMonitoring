package com.alekseyz.testtask.metricproducermicroservice.controller;

import com.alekseyz.testtask.metricproducermicroservice.dto.SendMetricDto;
import com.alekseyz.testtask.metricproducermicroservice.service.SendMetricService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Tag(name="Producer Api"
        , description="Нужно для сбора метрик от внешних источников ")
@RequiredArgsConstructor
@RestController
@RequestMapping(("/metrics"))
public class ProducerController {

    private final SendMetricService sendMetricService;

    @Operation(
            summary = "Сбор метрик",
            description = "Принимает POST запросы с Json"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void sendMetric(@RequestBody SendMetricDto sendMetricDto) {
        sendMetricService.sendMetric("metrics-topic", sendMetricDto);
    }

}


