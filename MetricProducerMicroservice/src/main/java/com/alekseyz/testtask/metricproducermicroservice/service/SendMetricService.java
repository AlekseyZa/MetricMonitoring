package com.alekseyz.testtask.metricproducermicroservice.service;

import com.alekseyz.testtask.metricproducermicroservice.dto.SendMetricDto;

public interface SendMetricService {
    void sendMetric(String topicName, SendMetricDto sendMetricDto);
}
