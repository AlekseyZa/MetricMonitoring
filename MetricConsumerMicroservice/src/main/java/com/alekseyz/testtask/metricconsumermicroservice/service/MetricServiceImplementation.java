package com.alekseyz.testtask.metricconsumermicroservice.service;


import com.alekseyz.testtask.metricconsumermicroservice.dto.ReadMetricDto;
import com.alekseyz.testtask.metricconsumermicroservice.entity.MetricEntity;
import com.alekseyz.testtask.metricconsumermicroservice.mapper.ReadMetricMapper;
import com.alekseyz.testtask.metricconsumermicroservice.mapper.SaveMetricMapper;
import com.alekseyz.testtask.metricconsumermicroservice.repository.MetricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MetricServiceImplementation implements MetricService {

    private final MetricRepository metricRepository;
    private final SaveMetricMapper saveMetricMapper;
    private final ReadMetricMapper readMetricMapper;

    @Transactional
    public MetricEntity saveMetric(List<String> metric) {
        return Optional.of(metric)
                .map(saveMetricMapper::map)
                .map(metricRepository::save).orElseThrow();
    }

    @Override
    public List<ReadMetricDto> getAllMetric() {
        return metricRepository.findAll()
                .stream()
                .map(readMetricMapper::map)
                .toList();
    }

    @Override
    public Optional<ReadMetricDto> getMetric(Long id) {
        return  metricRepository.findById(id)
                .map(readMetricMapper::map);
    }
}
