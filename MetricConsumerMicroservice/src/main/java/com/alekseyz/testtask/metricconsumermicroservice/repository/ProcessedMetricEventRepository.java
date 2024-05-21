package com.alekseyz.testtask.metricconsumermicroservice.repository;

import com.alekseyz.testtask.metricconsumermicroservice.entity.ProcessedMetricEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessedMetricEventRepository extends JpaRepository<ProcessedMetricEventEntity,Long> {

    ProcessedMetricEventEntity findByMessageId(String messageId);
}
