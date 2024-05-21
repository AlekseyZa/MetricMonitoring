package com.alekseyz.testtask.metricconsumermicroservice.service;

import com.alekseyz.testtask.metricconsumermicroservice.entity.ProcessedMetricEventEntity;

public interface ProcessedMetricEventService {
    ProcessedMetricEventEntity findByMessageId(String messageId);

    void save(ProcessedMetricEventEntity processedMetricEventEntity);
}
