package com.alekseyz.testtask.metricconsumermicroservice.controller;


import com.alekseyz.testtask.metricconsumermicroservice.dto.ReadMetricDto;
import com.alekseyz.testtask.metricconsumermicroservice.service.MetricService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Tag(name="Consumer Api"
        , description="Нужно для просмотра метрик")
@RequiredArgsConstructor
@RestController()
@RequestMapping("/metrics")
public class ConsumerController {

    private final MetricService metricService;

    @Operation(
            summary = "Вывод всех метрик",
            description = "Отображает весь список метрик, имеющихся в БД"
    )
    @GetMapping("")
    public List<ReadMetricDto> getMetrics() {
        return metricService.getAllMetric();
    }

    @Operation(
            summary = "Вывод одной метрики",
            description = "Отображает метрику по указанному Id"
    )
    @GetMapping("/{id}")
    public ReadMetricDto getMetric(@PathVariable("id") Long id) {
        return metricService.getMetric(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
