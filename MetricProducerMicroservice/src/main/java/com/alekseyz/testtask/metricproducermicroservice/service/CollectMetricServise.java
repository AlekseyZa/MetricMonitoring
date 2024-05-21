package com.alekseyz.testtask.metricproducermicroservice.service;


import com.alekseyz.testtask.metricproducermicroservice.dto.GeneratorDto;

import java.util.List;

public interface CollectMetricServise {
    List<GeneratorDto> collectMetric();

}
