package com.alekseyz.testtask.metricconsumermicroservice.service;

import com.alekseyz.testtask.metricconsumermicroservice.entity.ProcessedMetricEventEntity;
import com.alekseyz.testtask.metricconsumermicroservice.repository.ProcessedMetricEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessedMetricEventServiceImplementation implements ProcessedMetricEventService{

    private final ProcessedMetricEventRepository processedMetricEventRepository;

    public ProcessedMetricEventEntity findByMessageId(String messageId){
        return processedMetricEventRepository.findByMessageId(messageId);
    }

    @Override
    public void save(ProcessedMetricEventEntity processedMetricEventEntity) {
        processedMetricEventRepository.save(processedMetricEventEntity);
    }
}
