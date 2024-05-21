package com.alekseyz.testtask.metricconsumermicroservice.handler;


import com.alekseyz.testtask.metricconsumermicroservice.entity.MetricEntity;
import com.alekseyz.testtask.metricconsumermicroservice.entity.ProcessedMetricEventEntity;
import com.alekseyz.testtask.metricconsumermicroservice.service.MetricService;
import com.alekseyz.testtask.metricconsumermicroservice.service.ProcessedMetricEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component

public class MetricCreatedEventHandler {

    private final MetricService metricService;
    private final ProcessedMetricEventService processedMetricEventService;

    @Transactional
    @KafkaListener(topics = "metrics-topic")
    public void handle(@Payload List<String> metricCreatedEvent,
                       @Header("messageId") String messageId) {
        if (processedMetricEventService.findByMessageId(messageId) != null) {
            log.info("Пришло сообщение с дублирующим messageId: {}, сохранение в БД уже было выполнено ранее", messageId);
            return;
        }

        MetricEntity metricEntity = metricService.saveMetric(metricCreatedEvent);
        processedMetricEventService.save(ProcessedMetricEventEntity.builder()
                .messageId(messageId)
                .metricEntity(metricEntity)
                .build());

        log.info("Метрика получена и отправлена на сохранение в БД. Источник: {}, тип: {}, название: {}, значение: {}, временная метка: {}.",
                metricCreatedEvent.get(0),
                metricCreatedEvent.get(1),
                metricCreatedEvent.get(2),
                metricCreatedEvent.get(3),
                metricCreatedEvent.get(4)

        );


    }


}

