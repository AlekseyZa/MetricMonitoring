package com.alekseyz.testtask.metricconsumermicroservice.mapper;

import com.alekseyz.testtask.metricconsumermicroservice.dto.ReadMetricDto;
import com.alekseyz.testtask.metricconsumermicroservice.entity.MetricEntity;
import org.springframework.stereotype.Component;

@Component
public class ReadMetricMapper implements Mapper<MetricEntity, ReadMetricDto>{
    @Override
    public ReadMetricDto map(MetricEntity metricEntity) {

        return  ReadMetricDto.builder()
                .id(metricEntity.getId())
                .source(metricEntity.getSource())
                .metricType(metricEntity.getMetricSetType())
                .metricName(metricEntity.getMetricName())
                .metricValue(metricEntity.getMetricValue())
                .timestamp(String.valueOf(metricEntity.getTimestamp()))
                .build();

    }
}
