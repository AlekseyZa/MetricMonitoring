package com.alekseyz.testtask.metricconsumermicroservice.mapper;

import com.alekseyz.testtask.metricconsumermicroservice.entity.MetricEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SaveMetricMapper implements Mapper<List<String>, MetricEntity> {

    public MetricEntity map(List<String> metric) {
        return MetricEntity.builder()
                .source(metric.get(0))
                .metricSetType(metric.get(1))
                .metricName(metric.get(2))
                .metricValue(metric.get(3))
                .timestamp(LocalDateTime.parse(metric.get(4)))
                .build();
    }
}
