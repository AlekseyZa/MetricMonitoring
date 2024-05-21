package com.alekseyz.testtask.metricproducermicroservice.service.implementation;

import com.alekseyz.testtask.metricproducermicroservice.service.CollectMetricServise;
import com.alekseyz.testtask.metricproducermicroservice.service.MetricAutoGeneratorService;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@Slf4j
@Service
public class MetricAutoGeneratorServiceImplementation implements MetricAutoGeneratorService {

    private final CollectMetricServise collectMetricServise;
    private final RestTemplate restTemplate;
    private final ObjectWriter objectWriter;

    @Value("${server.port}")
    private int serverPort;

    @Scheduled(cron = "0/15 * * * * ?")
    public void createMetricSet() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:{port}/metrics")
                .build(serverPort);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        collectMetricServise.collectMetric().forEach(metric -> {
            try{
                restTemplate.postForEntity(uri, new HttpEntity<>(objectWriter.writeValueAsString(metric), headers), String.class);

            } catch (Exception e) {
                log.error("Произошла ошибка в Автогенераторе метрик, ошибка: {}, причина: {}",
                        e.getMessage(), e.getCause());
            }
        });
    }
}
