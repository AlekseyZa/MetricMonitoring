package com.alekseyz.testtask.metricproducermicroservice.service.implementation;

import com.alekseyz.testtask.metricproducermicroservice.dto.SendMetricDto;
import com.alekseyz.testtask.metricproducermicroservice.mapper.SendMetricMapper;
import com.alekseyz.testtask.metricproducermicroservice.service.SendMetricService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class SendMetricServiceImplementation implements SendMetricService {

    private final KafkaTemplate<String, List<String>> kafkaTemplate;
    private final SendMetricMapper sendMetricMapper;

    public void sendMetric(String topicName, SendMetricDto sendMetricDto) {
        String stringUUID = UUID.randomUUID().toString();

        ProducerRecord<String, List<String>> metricRecord = new ProducerRecord<>(
                "metrics-topic",
                stringUUID,
                sendMetricMapper.map(sendMetricDto)
        );

        metricRecord.headers().add("messageId", stringUUID.getBytes());
        kafkaTemplate.send(metricRecord);
        log.info("Метрика направлена в Consumer. Источник: {}, тип: {}, название: {}, значение: {}, временная метка: {}.",
                sendMetricDto.getSource(),
                sendMetricDto.getMetricType(),
                sendMetricDto.getMetricName(),
                sendMetricDto.getMetricValue(),
                sendMetricDto.getTimestamp()
        );
    }


}
