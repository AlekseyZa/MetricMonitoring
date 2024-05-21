package com.alekseyz.testtask.metricconsumermicroservice.service;

import com.alekseyz.testtask.metricconsumermicroservice.dto.ReadMetricDto;
import com.alekseyz.testtask.metricconsumermicroservice.entity.MetricEntity;

import java.util.List;
import java.util.Optional;

public interface MetricService {
    MetricEntity saveMetric(List<String> metricSet);

    List<ReadMetricDto> getAllMetric();

    Optional<ReadMetricDto> getMetric(Long id);
}
