package com.alekseyz.testtask.metricproducermicroservice.service.implementation;


import com.alekseyz.testtask.metricproducermicroservice.dto.GeneratorDto;
import com.alekseyz.testtask.metricproducermicroservice.service.CollectMetricServise;
import com.sun.management.OperatingSystemMXBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CollectMetricServiceImplementation implements CollectMetricServise {

    private final OperatingSystemMXBean operatingSystemMXBean =
            (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    public List<GeneratorDto> collectMetric() {
        return Arrays.asList(new GeneratorDto(
                        "Producer Microservice Host",
                        "HostMetrics",
                        "Cвободная память JVM",
                        String.valueOf(Runtime.getRuntime().freeMemory()),
                        LocalDateTime.now()),
                new GeneratorDto(
                        "Producer Microservice Host",
                        "HostMetrics",
                        "Всего память JVM",
                        String.valueOf(Runtime.getRuntime().totalMemory()),
                        LocalDateTime.now()),
                new GeneratorDto(
                        "Producer Microservice Host",
                        "HostMetrics",
                        "Процессоров доступно JVM",
                        String.valueOf(Runtime.getRuntime().availableProcessors()),
                        LocalDateTime.now()),
                new GeneratorDto(
                        "Producer Microservice Host",
                        "HostMetrics",
                        "Нагрузка на процессор от JVM",
                        String.valueOf(operatingSystemMXBean.getProcessCpuLoad()),
                        LocalDateTime.now()),
                new GeneratorDto(
                        "Producer Microservice Host",
                        "HostMetrics",
                        "Свободно физической памяти",
                        String.valueOf(operatingSystemMXBean.getFreeMemorySize()),
                        LocalDateTime.now()));
    }

}
